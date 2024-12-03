package sensor;

import kafka.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.kafka.telemetry.event.SensorEventAvro;

import java.time.Instant;

@RestController
@RequestMapping("/events")
public class SensorController {

    private final KafkaProducerService kafkaProducerService;

    public SensorController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Обработчик событий сенсоров.
     *
     * @param request Входящие данные сенсора в формате JSON.
     * @return HTTP-ответ.
     */
    @PostMapping("/sensors")
    public ResponseEntity<Void> collectSensorEvent(@RequestBody SensorEventRequest request) {
        // Преобразование JSON-запроса в Avro-объект
        SensorEventAvro avroEvent = convertToAvro(request);

        // Отправка события в Kafka
        kafkaProducerService.sendToKafka("telemetry.sensors.v1", avroEvent);

        return ResponseEntity.ok().build();
    }

    /**
     * Преобразование JSON-запроса в Avro-объект.
     *
     * @param request JSON-запрос.
     * @return Avro-объект SensorEventAvro.
     */
    private SensorEventAvro convertToAvro(SensorEventRequest request) {
        SensorEventAvro avroEvent = new SensorEventAvro();
        avroEvent.setId(request.getId());
        avroEvent.setHubId(request.getHubId());
        // Преобразование строки timestamp в long
        avroEvent.setTimestamp(Instant.parse(request.getTimestamp()).toEpochMilli());
        avroEvent.setPayload(request.getPayload());
        return avroEvent;
    }
}
