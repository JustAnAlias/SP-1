/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author RL^
 */
public class Handler extends Thread {
    public List<String> lines;    
    public Handler(List<String> lines) {this.lines = lines;}
    
    @Override
    public void run() {

            while(true) {
                try { Thread.sleep(15000); } 
                catch (Exception e) {}
            try {
                FileWriter writer = new FileWriter("backup.txt", false);
                PrintWriter out = new PrintWriter(writer);
                for (String line : lines) {
                    out.println(line);
                } 
                out.close();            
                } 
            catch (IOException iOException) {
            }
        }
    }
}
    
