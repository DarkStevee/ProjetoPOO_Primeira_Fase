package Actuators;

import Program.Identifier;
import Program.Room;
import Sensors.TemperatureSensor;
import java.time.LocalTime;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe tomada que extend a classe de Atuadores, responsavel por
 * ligar e temporizar atuadores
 *
 */
public class PowerPlug extends Actuator {

    private Identifier plugId;
    private boolean on;
    private LocalTime internalTime;
    private TemperatureSensor tempSensor;

    public PowerPlug(Room room) {
        super(room);
        plugId = new Identifier("Plug");
        on = false;
        internalTime = null;
        tempSensor = null;

    }

    /**
     * Metodo que conecta o sensor de temperatura a uma tomada
     *
     * @param tempSensor - sensor de temperatura
     */
    public void connectTemperatureSensor(TemperatureSensor tempSensor) {
        this.tempSensor = tempSensor;
    }

    /**
     * Metodo de desativação do sensor de temperatura
     */
    public void unplugSensor() {
        tempSensor = null;
    }

    /**
     *
     * @return - um idenficador
     */
    public Identifier getIdentifier() {
        return plugId;
    }

    /**
     *
     * @return - estado da tomada
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Metodo liga/desliga a tomada
     *
     * @param state - boolean de alteração.
     */
    public void changeState(boolean state) {
        on = state;
    }

    /**
     * Temporizador da tomada para desligamento
     *
     * @param minutes - tempo para desligamento que é somado ao tempo geral
     */
    public void turnOffAfterMinutes(long minutes) {
        //metodo não testado, pois não funcionamento para implementar no momento.
        if (minutes > 0 && internalTime == null) {
            internalTime = LocalTime.now().plusMinutes(minutes);
        } else {
            throw new IllegalArgumentException("Please insert minutes that are valid");
        }
    }

    /**
     * Temporizador da tomada para acionamento
     *
     * @param minutes - tempo para desligamento que é somado ao tempo geral
     *
     */
    public void turnOnAfterMinutes(long minutes) {
        //metodo não testado, pois não funcionamento para implementar no momento.
        if (minutes > 0 && internalTime == null) {
            internalTime = LocalTime.now().plusMinutes(minutes);
        } else {
            throw new IllegalArgumentException("Please insert minutes that are valid");
        }
    }

    /**
     * Metodo de acionamento de todos os metodos da classe
     */
    public void act() {
        if (internalTime != null) {
            if (LocalTime.now().equals(internalTime)) {
                if (on) {
                    changeState(false);
                } else {
                    changeState(true);
                }
            }
        }
    }
}
