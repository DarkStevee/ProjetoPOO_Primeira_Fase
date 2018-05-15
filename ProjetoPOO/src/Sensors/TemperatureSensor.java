package Sensors;

import Actuators.PowerPlug;
import Exceptions.NotPluggedInException;
import Program.Room;

public class TemperatureSensor extends Sensor {

    private int temperature;
    private PowerPlug plug;
  //  private int temperatureInterval;
  //  private int idealTemperature;

    public TemperatureSensor(PowerPlug plug, int temperature, Room room) {
        super(room);
        this.plug = plug;
        this.temperature = temperature;
   //     this.temperatureInterval = temperatureInterval;
   //     this.idealTemperature = idealTemperature;
    }
    
    public int getTemperature() throws NotPluggedInException {
        if (plug == null || !plug.isOn()) {
        	throw new NotPluggedInException("The plug to this sensor is not plugged in or is off");
        } else {
        	  return temperature;
        }
    }
    
    public void setTemperature(int temperature) {
    	if(plug.isOn() && temperature > 0)
    		this.temperature = temperature;
    }
    
   /* public int getIdealTemperature() {
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
    }*/
    
    
}
