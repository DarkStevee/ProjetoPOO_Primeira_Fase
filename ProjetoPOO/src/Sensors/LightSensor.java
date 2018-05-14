package Sensors;


public class LightSensor extends Sensor {
    
    
    private int light; //0 a 100%
    
    public LightSensor(int initialLight) {
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

    @Override
    public boolean isOkay() {
        return (light < 100 && light > 0);
    }
}
