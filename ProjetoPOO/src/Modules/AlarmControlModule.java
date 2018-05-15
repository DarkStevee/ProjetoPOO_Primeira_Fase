package Modules;

import Actuators.Alert;
import Exceptions.MovementSensorNotOnException;
import Media.*;
import Program.Room;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe do modulo de controlo do alarme
 *
 */
public class AlarmControlModule extends Module {

    private Alert alert;

    public AlarmControlModule(ArrayList<Room> rooms, Alert alert) {
        super(rooms);
        this.alert = alert;
    }

    /**
     * Metodo reponsavel pela detecção de um intruso com retorno boolean caso haja um intruso
     *
     * @param room
     * @return
     */
    public boolean intruderDetection(Room room) {
        try {
            if ((room.getOpenDoorSensor().getOpenDoor() || room.getMovementSensor().hasMovement()) && alert.getActivated()) {
                return true;
            }
        } catch (MovementSensorNotOnException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * Metodo de acionamento da camera fotografica
     *
     * @param typePhoto
     * @param idRoom
     */
    public void takePhoto(TypePhoto typePhoto, int idRoom) {
        Photo photo = new Photo(typePhoto, idRoom);
        SaveAndLoadFiles.savePhoto("photo", photo);
    }

    /**
     * Metodo de acionamento da video camera
     *
     * @param idRoom - id da divisão onde sera acionado
     */
    public void takeVideo(int idRoom) {
        Video video = new Video(idRoom);
        SaveAndLoadFiles.saveVideo("video", video);
    }

    /**
     * Metodo de acionamento da Sirene
     */
    public void ringAlert() {
        alert.changeVolume(10);
    }

    public void setAlert(char[] pin, Room room) {
        if (Arrays.equals(pin, alert.getPin())) {
            alert.changeVolume(0);
        }
    }

    /**
     * Metodo de acionamento de todos os metodos da classe
     */
    @Override
    public void act() {
        for (Room r : rooms) {
            if (intruderDetection(r)) {
                ringAlert();
                takeVideo(r.getId());
                takePhoto(TypePhoto.HORIZONTAL, r.getId());
            }
        }
    }
}
