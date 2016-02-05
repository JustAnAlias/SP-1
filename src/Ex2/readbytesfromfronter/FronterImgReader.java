/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readbytesfromfronter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Michael
 */
public class FronterImgReader implements Runnable{
    boolean done = false;
    boolean hasReturned = false;
    String url;
    int res;
    
    public FronterImgReader(String url){
        this.url = url;
        
    }
    
    @Override
    public void run() {
        res = getBytesFromUrl().length;
    }

    
    protected byte[] getBytesFromUrl(){
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try{
            System.out.println("trying to get size of: " + url);
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while((read=is.read(bytebuff))>0){
                bis.write(bytebuff, 0, read);
            }
        }
        catch(IOException ex){
            System.out.println("something went wrong!");
            ex.printStackTrace();
            
        }
        if(bis.toByteArray().length<1){
            return getBytesFromUrl();
        }
        else{
            return bis.toByteArray();
        }
        
    }
    
    public int getResult(){
        hasReturned = true;
        return res;
    }
    
    public boolean isDone(){
        return done;
    }
    
    public String getUrl(){
        return url;
    }
    
    public boolean hasReturned(){
        return hasReturned;
    }
    
}
