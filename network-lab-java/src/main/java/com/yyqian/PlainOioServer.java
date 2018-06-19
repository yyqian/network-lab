package com.yyqian;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Author: Yinyin Qian
 * Date: 2018-06-19
 */
public class PlainOioServer {
    public void server(int port) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(port);
        try {
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                System.out.println("accepted connection from port: " + clientSocket.getPort());
                new Thread(() -> {
                    OutputStream out;
                    try {
                        out = clientSocket.getOutputStream();
                        out.write("==hello==\n".getBytes(StandardCharsets.UTF_8));
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new PlainOioServer().server(8080);
    }
}
