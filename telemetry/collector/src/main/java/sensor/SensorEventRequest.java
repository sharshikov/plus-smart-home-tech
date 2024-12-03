package sensor;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LightSensorEventRequest.class, name = "LIGHT_SENSOR_EVENT"),
        @JsonSubTypes.Type(value = TemperatureSensorEventRequest.class, name = "TEMPERATURE_SENSOR_EVENT"),
        @JsonSubTypes.Type(value = MotionSensorEventRequest.class, name = "MOTION_SENSOR_EVENT"),
        @JsonSubTypes.Type(value = ClimateSensorEventRequest.class, name = "CLIMATE_SENSOR_EVENT"),
        @JsonSubTypes.Type(value = SwitchSensorEventRequest.class, name = "SWITCH_SENSOR_EVENT")
})
public abstract class SensorEventRequest {
    private String id;
    private String hubId;
    private String timestamp;

    public abstract Object getPayload();

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
