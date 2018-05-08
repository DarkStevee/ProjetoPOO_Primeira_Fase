package Atuadores;

import Sensores.SensorTemperatura;

public class ArCondicionado implements SensorTemperatura {
    private boolean arCondiocionadoSituação;//16 e 28

    public ArCondicionado(){
        setLigadoAirConditioning(false);
    }


    public boolean isLigadoAirConditioning() {
        return ligadoAirConditioning;
    }

    public void setLigadoAirConditioning(boolean ligadoAirConditioning) {
        this.ligadoAirConditioning = ligadoAirConditioning;
    }
}
