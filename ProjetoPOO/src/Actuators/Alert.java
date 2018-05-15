package Actuators;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Alerta que extend a classe de Atuadores Classe
 * responsavel pela ativação/desativação da sirene
 *
 */
public class Alert extends Actuator {

    private int alertVolume;// 0 e 10
    private boolean activated;
    private char[] pin;

    public Alert(char[] pin) {
        super(null);
        alertVolume = 0;
        activated = false;
        this.pin = pin;
    }

    /**
     * Metodo responsavel por aumentar e baixar volume da sirene
     *
     * @param alertVolume - a altura entre 0 e 10 que sera setada
     * @throws IllegalArgumentException
     */
    public void changeVolume(int alertVolume) throws IllegalArgumentException {
        if (alertVolume < 0 || alertVolume > 10) {
            throw new IllegalArgumentException("Volume is not valid");
        }
        this.alertVolume = alertVolume;
    }

    /**
     * Metodo de ativação/desativação da sirene
     *
     * @param change - valor booleano 
     */
    public void changeActivated(boolean change) {
        activated = change;
    }

    public boolean getActivated() {
        return activated;
    }

    public char[] getPin() {
        return pin;
    }

}
