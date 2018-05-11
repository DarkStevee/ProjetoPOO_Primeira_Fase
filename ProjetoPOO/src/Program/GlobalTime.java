/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.time.LocalTime;

/**
 *
 * @author AndreLaptop
 */
public class GlobalTime {
    public static final LocalTime TIME = LocalTime.now();
    
    
    public static LocalTime getInstance() {
        return TIME;
    }
    
    public static String formattedDate() {
        return "Data formatada";
    }
}
