package Modules;

import Actuators.Actuator;
import Actuators.AirConditioning;
import Program.Room;
import Sensors.Sensor;
import Sensors.TemperatureSensor;
import java.util.ArrayList;




public class TemperatureControlModule extends Module {

    public TemperatureControlModule(){
        super();
    }
    
    public void addRooms(ArrayList<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    @Override
    public void act() {
      for(Room r : rooms) {
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
          }
      }  
    }
    
}
