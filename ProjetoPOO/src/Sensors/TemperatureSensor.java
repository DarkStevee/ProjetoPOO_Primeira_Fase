package Sensors;

import Actuators.AirConditioning;
import Actuators.PowerPlug;
import Exceptions.NotPluggedInException;

public class TemperatureSensor extends Sensor {

    private int temperature;
    private PowerPlug plug;
    private int temperatureInterval;
    private int idealTemperature;

    public TemperatureSensor(PowerPlug plug, int temperatureInterval, int temperature, int idealTemperature) {
        this.plug = plug;
        this.temperature = temperature;
        this.temperatureInterval = temperatureInterval;
        this.idealTemperature = idealTemperature;
    }
    
    public int getTemperature() throws NotPluggedInException {
        if (plug.isOn()) {
            return temperature;
        } else {
            throw new NotPluggedInException("The plug to this sensor is not plugged in or is off");
        }
    }
    
    public int getIdealTemperature() {
        return idealTemperature;
    }
    
    public void setTemperature(AirConditioning ac) {
        ac.setTemperature(idealTemperature);
        this.temperature = ac.getRoomTemperature();
    }
    
    public int getTemperatureInterval() {
        return temperatureInterval;
    }
    
    public void setTemperatureInterval(int interval) throws IllegalArgumentException {
        if (interval > 0 && interval < 10) {
            this.temperatureInterval = interval;
        } else {
            throw new IllegalArgumentException("Interval must be positive and below 10");
        }
    }

    @Override
    public boolean isOkay() {
        try {
            return getTemperature() < idealTemperature + temperatureInterval && getTemperature() > idealTemperature - temperatureInterval;
        } catch (NotPluggedInException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
