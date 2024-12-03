package hub;

public class ScenarioRemovedEventRequest extends HubEventRequest {
    private String name;

    @Override
    public Object getPayload() {
        return this;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
