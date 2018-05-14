
package Program;

import java.time.LocalTime;


public class GlobalTime {
    public static final LocalTime TIME = LocalTime.now();
    
    
    public static LocalTime getInstance() {
        return TIME;
    }
    
    public static String formattedDate() {
        return "Data formatada";
    }
}
