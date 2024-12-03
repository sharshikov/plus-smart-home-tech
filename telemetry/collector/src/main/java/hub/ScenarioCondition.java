package hub;

public class ScenarioCondition {
    private String sensorId; // Идентификатор сенсора
    private ConditionType type; // Тип условия (перечисление)
    private ConditionOperation operation; // Операция сравнения (перечисление)
    private Object value; // Значение для сравнения (например, true, 50)

    // Геттеры и сеттеры
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public ConditionType getType() {
        return type;
    }

    public void setType(ConditionType type) {
        this.type = type;
    }

    public ConditionOperation getOperation() {
        return operation;
    }

    public void setOperation(ConditionOperation operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

