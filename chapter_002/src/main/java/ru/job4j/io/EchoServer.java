package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            System.out.println("Exit");
                            System.exit(0);
                        } else if (str.contains("Hello")) {
                            out.write(("Hello, dear friend." + System.lineSeparator()).getBytes());
                        } else if (str.contains("Any")) {
                            out.write(("Any" + System.lineSeparator()).getBytes());
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                }
            }
        } catch (IOException e) {
            LOG.error("Error", e);
        }
    }
}