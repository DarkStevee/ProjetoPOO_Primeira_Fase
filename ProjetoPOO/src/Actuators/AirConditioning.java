package Actuators;

public class AirConditioning extends Actuator {

    private int roomTemperature; // 16 a 28
    private boolean on;

    public AirConditioning(int roomTemperature) {
        this.roomTemperature = roomTemperature;
        on = false;
    }

    public void turnOn() {
        on = true;
    }

    public void setTemperature(int temperature) {
        if (on) {
            if (temperature >= 16 && temperature <= 28) {
                this.roomTemperature = temperature;
            } else {
                throw new IllegalArgumentException("The temperature is over the capabilities of the ac");
            }
        }
    }

    public int getRoomTemperature() {
        return roomTemperature;
    }
}
