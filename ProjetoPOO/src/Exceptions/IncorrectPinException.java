package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro estende uma Exception para Pin incorreto na desativação da sirene
 *
 */
public class IncorrectPinException extends Exception {
/**
 * gera uma mensagem de erro devido a sirene estar desativada
 * @param message 
 */
    public IncorrectPinException(String message) {
        super(message);
    }
}
