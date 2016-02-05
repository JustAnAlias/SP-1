/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author RL^
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {

        Map<String, String> dictionary = new HashMap();
        dictionary.put("hund", "dog");
        dictionary.put("hus", "house");
        dictionary.put("skole", "school");
        dictionary.put("sej", "cool");
    

        // hardcoding cuz im busy
        int portNumber = 8080;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                )         
        {
            String inputLine;
            String outputLine = null;
            out.println("Welcome to the extended echo server...");
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("QUIT")) {
                    out.println("Exiting");
                    System.exit(0);

                }
                String[] userinput = inputLine.split("#");
                if (userinput.length != 2) {
                    out.println("Unknown command... Type QUIT to quit");
                } else {

                    String command = userinput[0];
                    String content = userinput[1];

                    switch (command) {
                        case "UPPER":
                            outputLine = content.toUpperCase();
                            break;
                        case "LOWER":
                            outputLine = content.toLowerCase();
                            break;
                        case "REVERSE":
                            outputLine = new StringBuilder(content).reverse().toString();
                            break;
                        case "TRANSLATE":
                            if (dictionary.containsKey(content)) {
                                outputLine = dictionary.get(content);
                            } else {
                                out.println("I don't know how to translate '" + content + "'");
                            }
                            break;

                        default:
                            out.println("Unknown command... type QUIT to quit");
                    }

                }
                if (outputLine != null) {
                    out.println(outputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
    

