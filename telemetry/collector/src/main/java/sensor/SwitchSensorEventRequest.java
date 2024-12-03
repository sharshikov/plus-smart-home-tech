package sensor;

public class SwitchSensorEventRequest extends SensorEventRequest {
    private boolean state;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
