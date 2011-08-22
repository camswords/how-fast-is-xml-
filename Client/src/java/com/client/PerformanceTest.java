package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PerformanceTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8080));

        PrintStream output = new PrintStream(socket.getOutputStream());
        output.print("GET / HTTP/1.1\r\n");
        output.print("Host: localhost:8080\r\n");
        output.print("\r\n");
        

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while(reader.ready()) {
            String line = reader.readLine();

            if (line == null) break;

            System.out.println(line);
        }
        output.close();
        reader.close();
    }
}
