package Exceptions;
//***************

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro estende uma Exception para caso os identificadores
 * estejam incorretor
 *
 */
public class ParedException extends Exception {
/**
 * gera uma mensagem de erro devido os identificadores estarem errados
 * @param message 
 */
    public ParedException(String message) {
        super(message);
    }
}
