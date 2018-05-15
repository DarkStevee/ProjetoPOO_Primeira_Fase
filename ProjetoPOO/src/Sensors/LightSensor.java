package Sensors;

import Program.Room;


public class LightSensor extends Sensor {
    
    
    private int light; //0 a 100%
    
    public LightSensor(int initialLight, Room room) {
        super(room);
        light = initialLight;
    }
    
    public int getLight() {
        return light;
    }
    
    public void setLight(int light) throws IllegalArgumentException{
        if(light < 0 || light > 100) {
            throw new IllegalArgumentException("Light has to be between 0 and 100");
        }
        this.light = light;
    }
}
