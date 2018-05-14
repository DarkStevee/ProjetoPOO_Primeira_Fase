package Actuators;

import Exceptions.InvalidInput;

public class Lightbulb extends Actuators {
    private int lightIntensity;
    private boolean onLightBulb;

    public Lightbulb() {
        lightIntensity = 0;
        onLightBulb = false;
    }
    
    void adjustLightIntensity(int lightIntensity)throws InvalidInput{
        if (lightIntensity < 0 || lightIntensity > 20) {
            throw new InvalidInput("Light intensity is not valid");
        }
        this.lightIntensity = lightIntensity;      
        onLightBulb = (lightIntensity>0);
      
    }
    
    
    

}
