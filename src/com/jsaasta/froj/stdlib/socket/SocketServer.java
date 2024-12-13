package com.jsaasta.froj.stdlib.socket;

import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;
import com.jsaasta.froj.stdlib.StdlibRuntimeError;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SocketServer implements FrojCallable {
    protected static BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private static ServerSocket serverSocket;
    private final String EXIT_CODE = "EXIT";

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        try {
            Double param = (Double) arguments.get(0);
            final int PORT = param.intValue();

            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Incoming connection from " + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.run();
                String nextMessage = getNextMessage();
                if(nextMessage.toLowerCase().contentEquals("exit")){
                    shutdown();
                    break;
                }
                try{
                    return Double.parseDouble(nextMessage);
                } catch (NumberFormatException e) {
                    return nextMessage;
                }
            }
            return EXIT_CODE;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            shutdown();
        }
    }

    public static String getNextMessage() throws InterruptedException {
        return messageQueue.take();
    }

    public static void shutdown() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error shutting down server: " + e.getMessage());
        }
    }

}
