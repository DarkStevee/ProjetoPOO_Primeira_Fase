package Actuators;


public class AirConditioning extends Actuators{
    private boolean on;//16 e 28

    public AirConditioning(){
        on = false;
    }

    public boolean isACOn() {
        return on;
    }

    public void setACOn(boolean on) {
        this.on = on;
    }
}
