package Exceptions;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro estende uma Exception para intensidade da luz incorreta
 *
 */
public class LightIntensityOutOfRangeException extends Exception {
/**
 * gera uma mensagem de erro devido a intensidade de luz estar incorrecta
 * @param message 
 */
    public LightIntensityOutOfRangeException(String message) {
        super(message);
    }
}
