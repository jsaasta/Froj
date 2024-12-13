package com.jsaasta.froj.stdlib.socket;

import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            if(bytesRead == -1){
                System.out.println("Client closed the Connection");
            }

            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            out.write(message.getBytes());

            SocketServer.messageQueue.put(message);

            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
