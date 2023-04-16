package za.co.wethinkcode.robotworlds.server.servers;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class MultiServer {
    public static final int PORT = 5000;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //variable pool keeps check of the cap number of clients currently its 50
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
        ) {
            System.out.println("Server running & waiting for client connections.");
            while (true) {
                Socket socket = serverSocket.accept();
                pool.execute(new SimpleServer(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
