/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actuators;

import Program.Room;

/**
 *
 * @author AndreLaptop
 */
public abstract class Actuator {

    protected Room room;

    public Actuator(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}
