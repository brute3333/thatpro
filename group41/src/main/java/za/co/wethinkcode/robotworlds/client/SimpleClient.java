package za.co.wethinkcode.robotworlds.client;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class SimpleClient {
    public static void main(String args[]) {
        try (
                Socket socket = new Socket("localhost", 5000);
                PrintStream out = new PrintStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
        )
        {
            String clientMessageToServer= "";
            while (!(clientMessageToServer = new Scanner(System.in).nextLine()).equalsIgnoreCase("quit")) {
                out.println(clientMessageToServer);
                out.flush();
                String messageFromServer = in.readLine();
                System.out.println("Response: " + messageFromServer);
                if (clientMessageToServer == "quit") {
                    System.out.println("shutting down "+socket.getInetAddress()+ "at port " +socket.getPort());

                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
