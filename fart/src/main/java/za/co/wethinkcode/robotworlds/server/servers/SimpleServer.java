package za.co.wethinkcode.robotworlds.server.servers;

import java.io.*;
import java.net.*;

public class SimpleServer implements Runnable {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintStream out;
    private final String clientMachine;

    public SimpleServer(Socket socket) throws IOException {
        this.socket = socket;
        clientMachine = socket.getInetAddress().getHostName();
        System.out.println("Connection from " + clientMachine);

        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        System.out.println("Waiting for client...");
    }

    public void run() {
        try {
            while(true) {
                String messageFromClient = in.readLine();
                if (messageFromClient == null) {
                    break;
                }
                System.out.println("Message \"" + messageFromClient + "\" from " + clientMachine);
                out.println("Thanks for this message: "+messageFromClient);
                out.flush();
            }
        } catch(IOException ex) {
            System.out.println("Error: "+ ex.getMessage());
        } finally {
            closeQuietly();
        }
    }

    private void closeQuietly() {
        try { in.close(); out.close(); socket.close();
        } catch(IOException ex) {}
    }
}
