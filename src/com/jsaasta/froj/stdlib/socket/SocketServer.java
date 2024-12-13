package com.jsaasta.froj.stdlib.socket;

import com.jsaasta.froj.FrojCallable;
import com.jsaasta.froj.Interpreter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SocketServer implements FrojCallable {
    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        try {
            Double param = (Double) arguments.get(0);
            int port = param.intValue();
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening for incoming connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Incoming connection from " + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
