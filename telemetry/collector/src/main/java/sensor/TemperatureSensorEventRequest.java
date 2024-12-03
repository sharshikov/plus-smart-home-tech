package sensor;

public class TemperatureSensorEventRequest extends SensorEventRequest {
    private int temperatureC;
    private int temperatureF;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public int getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(int temperatureC) {
        this.temperatureC = temperatureC;
    }

    public int getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(int temperatureF) {
        this.temperatureF = temperatureF;
    }
}
