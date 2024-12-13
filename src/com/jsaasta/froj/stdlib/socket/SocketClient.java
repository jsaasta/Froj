package com.jsaasta.froj.stdlib.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        while(true) {
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to server");

            // Get input and output streams
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(input);

            // Send message to server
            String message = reader.readLine();
            out.write(message.getBytes());

            // Read response from server
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Received response from server: " + response);

            // Close the socket
            socket.close();
        }
    }
}
