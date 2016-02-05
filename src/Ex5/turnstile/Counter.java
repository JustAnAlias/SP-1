/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turnstile;

/**
 *
 * @author RL^
 */
public class Counter {
    private int turns = 0;

    public String inputString(String str) {
        String reSpons;
        if (str.equalsIgnoreCase("T_")) { 
            turns++;
            reSpons = "Turnstile has been turned. Current turnID: " + turns + ".";
        } else if(str.equalsIgnoreCase("Counter")) {
            reSpons = "The turnstile has been turned " + turns + " times.";
        } else {
            reSpons = "Type Counter to see turnstile turns or T_";
        }
        return reSpons;
    }
}    
