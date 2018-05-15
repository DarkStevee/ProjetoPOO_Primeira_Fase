
package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro para Pin incorreto na desativação da sirene
 *
 */
public class IncorrectPinException extends Exception {
    
    public IncorrectPinException(String message) {
        super(message);
    }
}
