package hub;

public class DeviceAction {
    private String sensorId; // Идентификатор устройства
    private ActionType type; // Тип действия (перечисление)
    private Object value; // Значение для действия (например, установить уровень яркости)

    // Геттеры и сеттеры
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
