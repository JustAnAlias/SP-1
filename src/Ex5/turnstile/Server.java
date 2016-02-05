/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author RL^
 */
public class Server {


    
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080); // Faster to hardcore
        } catch (IOException e) {
            System.err.println("IOEx on port: 8080."); // Custom Error msg for shutdown
            System.exit(1); // Shutdown program with error msg
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String input; 
        String output;
        Counter c = new Counter();

        out.println("Type 'T_' to turn turnstile. Type 'Counter' to see current turn count.");

        while ((input = in.readLine()) != null) {
            output = c.inputString(input);
            out.println(output);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    
    
    
    
}
