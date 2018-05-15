package Exceptions;
/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Erro para intensidade da luz incorreta
 *
 */
public class LightIntensityOutOfRangeException extends Exception {

	public LightIntensityOutOfRangeException(String message) {
		super(message);
	}
}