package Program;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe GlobalTime, classe unica que gera uma tempo para ser usado como base
 *
 */
public class GlobalTime implements Serializable{

    public static final LocalTime TIME = LocalTime.now();

    public static LocalTime getInstance() {
        return TIME;
    }

    /**
     * Metodo para formatar a hora e retornar-la como String
     *
     * @return - String do localDate
     */
    public static String formattedDate() {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String formattedString = localDate.format(formatter);

        return formattedString;
    }

    /**
     * Metodo para se adiantar o tempo em 1 minuto
     */
    public static void forwardOneMinute() {
        TIME.plusMinutes(1);
    }
}
