package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro estende uma Exception para caso o sensor não esteja
 * ligado
 *
 */

public class MovementSensorNotOnException extends Exception {
/**
 * gera uma mensagem de erro devido o sensor estar desligado
 * @param message 
 */
    public MovementSensorNotOnException(String message) {
        super(message);
    }
}
