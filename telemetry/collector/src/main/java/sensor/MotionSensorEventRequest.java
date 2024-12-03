package sensor;

public class MotionSensorEventRequest extends SensorEventRequest {
    private boolean motion;
    private int linkQuality;
    private int voltage;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public boolean isMotion() {
        return motion;
    }

    public void setMotion(boolean motion) {
        this.motion = motion;
    }

    public int getLinkQuality() {
        return linkQuality;
    }

    public void setLinkQuality(int linkQuality) {
        this.linkQuality = linkQuality;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
