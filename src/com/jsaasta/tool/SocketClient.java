package com.jsaasta.tool;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

class SocketClient {

    public static void main(String[] args) throws IOException {
        while(true) {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(input);

            String message = reader.readLine();
            String response = sendMessage(message);
            if (response != null) {
                System.out.println("Received response from server: " + response);
            }
        }
    }

    private static String sendMessage(String message) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("Connected to server");

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            out.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String response = new String(buffer, 0, bytesRead);

            return response;
        } catch (ConnectException e) {
            System.out.println("Connection refused. Is the server running?");
            return null;
        } catch (IOException e) {
            System.out.println("Error sending message: " + e.getMessage());
            return null;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }

}
