
package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro estende uma Exception para caso o sensor não esteja implementado correctamente
 *
 */
public class SensorNotImplomentedException extends Exception {
/**
 * gera uma mensagem de erro devido aos sensores estejam implementados incorretamente
 * @param message 
 */
    public SensorNotImplomentedException(String message) {
        super(message);
    }

}
