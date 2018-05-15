package Actuators;

import Program.Room;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Ar condicionado responsavel pelo acionamento do aparalho
 *
 */
public class AirConditioning extends Actuator {

    private int roomTemperature; // 16 a 28
    private boolean on;

    /**
     * Contrutor Ar condicionado
     *
     * @param room - uma divisão
     * @param roomTemperature - temperatura atual dessa divisão
     */
    public AirConditioning(Room room, int roomTemperature) {
        super(room);
        this.roomTemperature = roomTemperature;
        on = false;
    }

    /**
     * Metodo responsavel pelo acionamento do aparelho
     *
     * @param state
     */
    public void turnOnOrOff(boolean state) {
        on = state;
    }

    /**
     * Metodo responsavel setar a temperatura atual do ambiente
     *
     * @param temperature - temperatura que ira ser setada
     */
    public void setTemperature(int temperature) {
        if (on) {
            if (temperature >= 16 && temperature <= 28) {
                this.roomTemperature = temperature;
            } else {
                throw new IllegalArgumentException("The temperature is over the capabilities of the ac");
            }
        }
    }

    /**
     * Metodo para retorno da temperatura
     *
     * @return temperatura da divisão
     */
    public int getRoomTemperature() {
        return roomTemperature;
    }
}
