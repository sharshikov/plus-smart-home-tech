package hub;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DeviceAddedEventRequest.class, name = "DEVICE_ADDED"),
        @JsonSubTypes.Type(value = DeviceRemovedEventRequest.class, name = "DEVICE_REMOVED"),
        @JsonSubTypes.Type(value = ScenarioAddedEventRequest.class, name = "SCENARIO_ADDED"),
        @JsonSubTypes.Type(value = ScenarioRemovedEventRequest.class, name = "SCENARIO_REMOVED")
})
public abstract class HubEventRequest {
    private String hubId;
    private String timestamp;

    public abstract Object getPayload();

    // Геттеры и сеттеры
    public String getHubId() {
        return hubId;
    }

    public void setHubId(String hubId) {
        this.hubId = hubId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

