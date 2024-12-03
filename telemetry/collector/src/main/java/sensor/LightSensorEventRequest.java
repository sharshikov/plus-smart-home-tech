package sensor;

public class LightSensorEventRequest extends SensorEventRequest {
    private int luminosity;
    private int linkQuality;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public int getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        this.luminosity = luminosity;
    }

    public int getLinkQuality() {
        return linkQuality;
    }

    public void setLinkQuality(int linkQuality) {
        this.linkQuality = linkQuality;
    }
}
