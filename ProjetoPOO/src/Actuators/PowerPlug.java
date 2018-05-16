package Actuators;

import Program.Identifier;
import Program.Room;
import Sensors.TemperatureSensor;
import java.time.LocalTime;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe tomada que extend a classe de Atuadores Classe responsavel por ligar e temporizar atuadores
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
     * @param tempSensor - um sensor de temperatura
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

    public Identifier getIdentifier() {
        return plugId;
    }
    
    public boolean isOn() {
        return on;
    }

    public void changeState(boolean state) {
        on = state;
    }

    /**
     * Temporizador da tomada para desligamento
     *
     * @param minutes
     */
    public void turnOffAfterMinutes(long minutes) {
        if (minutes > 0 && internalTime == null) {
            internalTime = LocalTime.now().plusMinutes(minutes);
        } else {
            throw new IllegalArgumentException("Please insert minutes that are valid");
        }
    }

    /**
     * Temporizador da tomada para acionamento
     *
     * @param minutes
     */
    public void turnOnAfterMinutes(long minutes) {
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
