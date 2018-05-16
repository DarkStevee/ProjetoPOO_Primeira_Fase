package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe que retorna um erro caso a tomada não esteja ligada
 *
 */
public class NotPluggedInException extends Exception {
/**
 * gera uma mensagem de erro devido a tomada estar desligada
 * @param message 
 */
    public NotPluggedInException(String message) {
        super(message);
    }
}
