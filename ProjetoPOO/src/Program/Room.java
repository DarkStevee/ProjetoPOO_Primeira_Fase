package Program;

import Actuators.Actuator;
import Sensors.Sensor;
import java.util.ArrayList;

public class Room {

    private static int count;

    private final int id;

    private ArrayList<Sensor> sensors;
    private ArrayList<Actuator> actuators;

    public Room(int initialTemperature) {
        id = ++count;
        sensors = new ArrayList<>();
        actuators = new ArrayList<>();
    }
    
    public void setSensors(ArrayList<Sensor> sensor) {
        sensors.addAll(sensor);
    }
    
    public void setActuator(ArrayList<Actuator> actuator) {
        actuators.addAll(actuator);
    }
    
    public ArrayList<Sensor> getSensors() {
        return sensors;
    }
    
    public ArrayList<Actuator> getActuators() {
        return actuators;
    }
    
    @Override
    public String toString() {
        String info = ("the Room number: "+id+" has these sensors:\n");
        info = sensors.stream().map((s) -> s.toString() +"\n").reduce(info, String::concat);
        info += "And these actuators:\n";
        info = actuators.stream().map((a) -> a.toString()+"\n").reduce(info, String::concat);
        return info;
    }
}
