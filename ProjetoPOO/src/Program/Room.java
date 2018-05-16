package Program;

import Actuators.*;
import Exceptions.LightIntensityOutOfRangeException;
import Exceptions.MovementSensorNotOnException;
import Exceptions.NotPluggedInException;
import Exceptions.SensorNotImplomentedException;
import Sensors.*;
import java.io.Serializable;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Classe Room, representa as divisões, onde em cada divisão, teremos nela os sensores e atuadores
 *
 */
public class Room implements Serializable{

    private static int count;
    private final int id;
    private int interval;
    private final int idealLight;
    private final int idealTemperature;

    private TemperatureSensor ts;
    private LightSensor ls;
    private OpenDoorSensor ods;
    private MovementSensor ms;

    private AirConditioning ac;
    private Lightbulb lb;
    private PowerPlug pp;

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
/**
 * Adiciona um act do ar condicionado aos pools de act
 * @param ac 
 */
    public void addAcToRoom(AirConditioning ac) {
        this.ac = ac;
    }
/**
 * Adiciona um act do lampadas aos pools de act
 * @param bulb 
 */
    public void addLightbulbToRoom(Lightbulb bulb) {
        this.lb = bulb;
    }
/**
 * Adiciona um act tomada aos pools de act
 * @param plug 
 */
    public void addPowerPlugToRoom(PowerPlug plug) {
        this.pp = plug;
    }

    
/**
 * Seta a intensidade da luminosidade
 * @param lightIntensity
 * @throws LightIntensityOutOfRangeException 
 */
    public void setLightIntensity(int lightIntensity) throws LightIntensityOutOfRangeException {
        if (lb != null) {
            lb.setLightIntensity(lightIntensity);
            //recebe luminosity de 0-10 converte para a escala 0-100
            ls.setLight((lightIntensity * 100) / 20);
        }
    }
/**
 * Metodo que seta a temperatura do ambiente
 * @param temperature 
 */
    public void setTemperature(int temperature) {
        if (ac != null) {
            ac.setTemperature(temperature); // check if temperature can be changed to this value, if not throws an exception
            ts.setTemperature(temperature);
        }
    }
/**
 * Seta um sensor de temperatura
 * @param ts 
 */
    public void setTemperatureSensor(TemperatureSensor ts) {
        ts.setRoom(this);
        this.ts = ts;
    }
/**
 * Setaum sensor de iluminação
 * @param ls 
 */
    public void setLightSensor(LightSensor ls) {
        ls.setRoom(this);
        this.ls = ls;
    }
/**
 * Seta um sensor de porta aberta
 * @param ods 
 */
    public void setOpenDoorSensor(OpenDoorSensor ods) {
        ods.setRoom(this);
        this.ods = ods;
    }
/**
 * Seta um sensor de movimento
 * @param ms 
 */
    public void setMovementSensor(MovementSensor ms) {
        ms.setRoom(this);
        this.ms = ms;
    }
/**
 * 
 * @return - sensor de temperatura
 */
    public TemperatureSensor getTemperatureSensor() {
        return ts;
    }
/**
 * 
 * @return - sensor de iluminação
 */
    public LightSensor getLightSensor() {
        return ls;
    }
/**
 * 
 * @return - sensor de porta aberta
 */
    public OpenDoorSensor getOpenDoorSensor() {
        return ods;
    }
/**
 * 
 * @return sensor de movimento
 */
    public MovementSensor getMovementSensor() {
        return ms;
    }
/**
 * 
 * @return - um ar condicionado
 */
    public AirConditioning getAirConditioning() {
        return ac;
    }
/**
 * 
 * @return - uma lampada
 */
    public Lightbulb getLightbulb() {
        return lb;
    }
/**
 * 
 * @return uma tomada.
 */
    public PowerPlug getPowerPlug() {
        return pp;
    }
/**
 * 
 * @return - o intervalo de temperatura
 */
    public int getInterval() {
        return interval;
    }
/**
 * Setar a diferenca de temperatura possivel para uma divisao
 * @param interval
 * @throws IllegalArgumentException - Erro caso o intervalo seja invalido
 */
    public void setInterval(int interval) throws IllegalArgumentException {
        if (interval < 0 || interval > 5) {
            throw new IllegalArgumentException("Interval must be between 0 and 5");
        }
        this.interval = interval;
    }
/**
 * 
 * @return - temperatura atual da divisão
 * @throws NotPluggedInException - Erro caso não esteja ligado a tomada
 * @throws SensorNotImplomentedException - Erro caso o sensor esteja desligado
 */
    public int getCurrentTemperature() throws NotPluggedInException, SensorNotImplomentedException {
        if (ts == null) {
            throw new SensorNotImplomentedException("luminosity sensor is not implomented");
        } else {
            return ts.getTemperature();
        }
    }
/**
 * 
 * @return - temperatura ideal para a divisao
 */
    public int getIdealTemperature() {
        return idealTemperature;
    }
/**
 * 
 * @return - iluminação ideal para a divisao
 */
    public int getIdealLight() {
        return idealLight;
    }
/**
 * 
 * @return - luminosidade da divisao
 * @throws SensorNotImplomentedException - Erro caso o sensor esteja desligado
 */
    public int getCurrentLuminosity() throws SensorNotImplomentedException {
        if (ls == null) {
            throw new SensorNotImplomentedException("luminosity sensor is not implomented");
        } else {
            return ls.getLight();
        }
    }
/**
 * 
 * @return - do estado da porta
 * @throws SensorNotImplomentedException caso o sensor não esteja ligado
 */
    public boolean isDoorOpen() throws SensorNotImplomentedException {
        if (ods == null) {
            throw new SensorNotImplomentedException("open door sensor is not implomented");
        } else {
            return ods.getOpenDoor();
        }
    }
/**
 * 
 * @return - se há movimento no ambiente
 * @throws MovementSensorNotOnException - erro caso o sensor esteja desligado
 * @throws SensorNotImplomentedException - Erro caso o sensor não esteja implementado
 */
    public boolean hasMovement() throws MovementSensorNotOnException, SensorNotImplomentedException {
        if (ms == null) {
            throw new SensorNotImplomentedException("movement sensor is not implomented");
        } else {
            return ms.hasMovement();
        }
    }
/**
 * 
 * @return String com as informações dos objetos.
 */
    @Override
    public String toString() {
        String info = ("the Room number: " + id + " has these sensors:\n");
        // info = sensors.stream().map((s) -> s.toString() + "\n").reduce(info, String::concat);
        info += "And these actuators:\n";
        //info = actuators.stream().map((a) -> a.toString() + "\n").reduce(info, String::concat);
        return info;
    }
/**
 * 
 * @param obj
 * @return - true caso os objetos sejam iguais.
 */
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
