package hub;

public class DeviceRemovedEventRequest extends HubEventRequest {
    private String id;

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
}