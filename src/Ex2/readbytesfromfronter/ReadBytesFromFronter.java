/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readbytesfromfronter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class ReadBytesFromFronter {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] urls = {"https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png", "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png", "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png"};
        List<FronterImgReader> threadList = new ArrayList();
        int returnCounter = 0;
        for (String s : urls){
            FronterImgReader reader = new FronterImgReader(s);
            Thread t1 = new Thread(reader);
            t1.start();
            threadList.add(reader);
        }
        
        while(returnCounter<threadList.size()){
            for (FronterImgReader temp : threadList) {
                if(temp.isDone() && !temp.hasReturned()){
                    System.out.println(temp.getUrl() + " contains " + temp.getResult() + " bytes");
                    returnCounter++;
                    
                }
            }
        }
        
    }
    
}
