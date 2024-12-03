package hub;

public class DeviceAddedEventRequest extends HubEventRequest {
    private String id;
    private String deviceType;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}

