
package Program;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class GlobalTime {
    public static final LocalTime TIME = LocalTime.now();
    
    
    public static LocalTime getInstance() {
        return TIME;
    }
    
    public static String formattedDate() {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);
        
        return formattedString;
    }
    
    public static void forwardOneMinute() {
        TIME.plusMinutes(1);
    }
}
