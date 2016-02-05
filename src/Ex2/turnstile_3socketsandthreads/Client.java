/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile_3socketsandthreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author RL^
 */
public class Client {    
    
    public static void main(String[] args) throws IOException {

        Socket Socket = null; 
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            Socket = new Socket("localhost", 8080);
            out = new PrintWriter(Socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host Error localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("IOEx at the connection point.");
            System.exit(1);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Server,User;

        while ((Server = in.readLine()) != null) {
            System.out.println(Server);
            User = br.readLine();
            out.println(User);
        }

        out.close();
        in.close();
        br.close();
        Socket.close();
    }
}