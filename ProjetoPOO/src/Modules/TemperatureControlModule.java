package Modules;

import Actuators.AirConditioning;
import Exceptions.NotPluggedInException;
import Program.Room;
import Sensors.TemperatureSensor;
import java.util.ArrayList;

public class TemperatureControlModule extends Module {

    public TemperatureControlModule(ArrayList<Room> rooms) {
        super(rooms);
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
                int idealTemp = r.getIdealTemperature();
                int intv = r.getInterval();
                int curTemp;
                try {
                    curTemp = r.getCurrentTemperature();
                    if (curTemp > intv + idealTemp || curTemp < idealTemp - intv) {
                        r.setTemperature(r.getIdealTemperature());
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
