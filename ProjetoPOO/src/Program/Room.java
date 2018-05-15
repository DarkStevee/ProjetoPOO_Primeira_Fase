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
    
    private final int idealLight;
    private final int idealTemperature;
    //initialize on console 
    private TemperatureSensor ts;
    private LightSensor ls;
    private OpenDoorSensor ods;
    private MovementSensor ms;

    private AirConditioning ac;
    private Lightbulb lb;
    private PowerPlug pp;
    //////////////////////////

    public Room(int idealTemperature, int interval, int idealLight) {
        id = ++count;
        this.interval = interval;
        this.idealTemperature = idealTemperature;
        this.idealLight = idealLight;
        //after it being built, the sensors must be added with sets.
        //the same with the actuators
    }
    
    public int getId() {
        return id;
    }

    public void addActuator(Actuator act) {
        if (act.getClass().equals(AirConditioning.class)) {
            this.ac = (AirConditioning) act;
        } else if (act.getClass().equals(Lightbulb.class)) {
            this.lb = (Lightbulb) act;
        } else if (act.getClass().equals(PowerPlug.class)) {
            this.pp = (PowerPlug) act;
        }
    }

    public void setTemperatureSensor(TemperatureSensor ts) {
        ts.setRoom(this);
        this.ts = ts;
    }

    public void setLightSensor(LightSensor ls) {
        ls.setRoom(this);
        this.ls = ls;
    }

    public void setOpenDoorSensor(OpenDoorSensor ods) {
        ods.setRoom(this);
        this.ods = ods;
    }

    public void setMovementSensor(MovementSensor ms) {
        ms.setRoom(this);
        this.ms = ms;
    }
    

    public TemperatureSensor getTemperatureSensor() {
        return ts;
    }
    
    public LightSensor getLightSensor() {
        return ls;
    }
    
    public OpenDoorSensor getOpenDoorSensor() {
        return ods;
    }
    
    public MovementSensor getMovementSensor() {
        return ms;
    }

    public AirConditioning getAirConditioning() {
        return ac;
    }
    
    public Lightbulb getLightbulb() {
        return lb;
    }
    
    public PowerPlug getPowerPlug() {
        return pp;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) throws IllegalArgumentException {
        if (interval < 0 || interval > 5) {
            throw new IllegalArgumentException("Interval must be between 0 and 5");
        }
        this.interval = interval;
    }

    public int getCurrentTemperature() throws NotPluggedInException {
        //	if (ts!= null)
        return ts.getTemperature();
    }

    public int getIdealTemperature() {
        return idealTemperature;
    }
    
    public int getIdealLight() {
        return idealLight;
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
        if (ac != null) {
            ac.setTemperature(temperature); // check if temperature can be changed to this value, if not throws an exception
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }
}
