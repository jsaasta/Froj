package com.jsaasta.froj.stdlib.socket;

import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;
import com.jsaasta.froj.stdlib.StdlibRuntimeError;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SocketServer implements FrojCallable {
    protected static BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private static ServerSocket serverSocket;
    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        try {
            Double param = (Double) arguments.get(0);
            int port = param.intValue();
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening for incoming connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Incoming connection from " + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
                String nextMessage = getNextMessage();
                try{
                    return Double.parseDouble(nextMessage);
                } catch (NumberFormatException e) {
                    return nextMessage;
                }
            }

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
