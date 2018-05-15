package Modules;

import Actuators.AirConditioning;
import Exceptions.NotPluggedInException;
import Program.Room;
import Sensors.TemperatureSensor;
import java.util.ArrayList;

public class TemperatureControlModule extends Module {

    public TemperatureControlModule() {
        super();
    }

    public void addRooms(ArrayList<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    @Override
    public void act() {
        for (Room r : rooms) {
            TemperatureSensor ts = r.getTemperatureSensor();
            AirConditioning ac = r.getAirConditioning();

            if (ts != null && ac != null) {
                int initialTemp = r.getIdealTemperature();
                int intv = r.getInterval();
                int curTemp;
                try {
                    curTemp = r.getCurrentTemperature();
                    if (curTemp > intv + initialTemp || curTemp < initialTemp - intv) {
                        r.setTemperature(curTemp);
                    }
                } catch (NotPluggedInException ex) {
                    System.out.println(ex.getMessage());
                }
                // alterar temperatura quarto e sensor
            }
        }

        /*
          for(Sensor s : r.getSensors()) {
              if(!s.isOkay()) {
                  if(s.getClass().equals(TemperatureSensor.class)) {
                      TemperatureSensor sensor = (TemperatureSensor) s;
                      for(Actuator a : r.getActuators()) {
                          if(a.getClass().equals(AirConditioning.class)) {
                              sensor.setTemperature((AirConditioning) a);
                          }
                      }
                  }  
              }
          }*/
    }

}
