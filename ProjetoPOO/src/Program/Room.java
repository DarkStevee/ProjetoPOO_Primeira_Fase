package Program;

import Actuators.*;
import Exceptions.LightIntensityOutOfRangeException;
import Exceptions.MovementSensorNotOnException;
import Exceptions.NotPluggedInException;
import Sensors.*;


public class Room {
    
    private static int count;
    
    private final int id;

    ////////////////////////
    private int interval;    
    
    private int idealTemperature;
    //initialize on console 
    private TemperatureSensor ts;
    private LightSensor ls;
    private OpenDoorSensor ods;
    private MovementSensor ms;    
    
    private AirConditioning ac;
    private Lightbulb lb;
    private Alert al;
    private PowerPlug pl;
    //////////////////////////
    
    public Room(int initialTemperature) {
        id = ++count;
        interval = 0;
        this.idealTemperature = initialTemperature;
        
        
    }
    
    public TemperatureSensor getTemperatureSensor() {
        return ts;
    }
    
    public AirConditioning getAirConditioning() {
        return ac;
    }
    
    public int getInterval() {
        return interval;
    }
    
    public int getCurrentTemperature() throws NotPluggedInException {
        //	if (ts!= null)
        return ts.getTemperature();
    }
    
    public int getIdealTemperature() {
        return idealTemperature;
    }
    
    public int getCurrentLuminosity() {
        if (ls != null) {
            return ls.getLight();
        }
        return 1; // placeholder exception this sensor is null.
    }
    
    public boolean isDoorOpen() {
        if (ods != null) {
            return ods.getOpenDoor();
        }
        return true; //placeholder same exception
    }
    
    public boolean hasMovement() throws MovementSensorNotOnException {
        if (ms != null) {
            return ms.hasMovement();
        }
        return true; //placeholder same
    }
    
    public void setLightIntensity(int lightIntensity) throws LightIntensityOutOfRangeException {        
        if (lb != null) {
            lb.setLightIntensity(lightIntensity);
            //this.luminosity = (lightIntensity * 100) / 20; //recebe luminosity de 0-10 converte para a escala 0-100
            ls.setLight((lightIntensity * 100) / 20);
        }
    }
    
    public void setTemperature(int temperature) {
        if(ac != null) {
            ac.setTemperature(temperature); // check if temperature can be changed to this value
            ts.setTemperature(temperature);
        }
    }
    
    @Override
    public String toString() {
        String info = ("the Room number: " + id + " has these sensors:\n");
       // info = sensors.stream().map((s) -> s.toString() + "\n").reduce(info, String::concat);
        info += "And these actuators:\n";
        //info = actuators.stream().map((a) -> a.toString() + "\n").reduce(info, String::concat);
        return info;
    }
}
