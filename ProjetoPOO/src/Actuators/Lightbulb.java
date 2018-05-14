package Actuators;


public class Lightbulb extends Actuator {
    private int lightIntensity;
    private boolean onLightBulb;

    public Lightbulb() {
        lightIntensity = 0;
        onLightBulb = false;
    }
    
    void adjustLightIntensity(int lightIntensity)throws IllegalArgumentException{
        if (lightIntensity < 0 || lightIntensity > 20) {
            throw new IllegalArgumentException("Light intensity is not valid");
        }
        this.lightIntensity = lightIntensity;      
        onLightBulb = (lightIntensity>0);
      
    }
    
    
    

}
