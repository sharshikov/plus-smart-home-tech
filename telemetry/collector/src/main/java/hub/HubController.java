package hub;

import kafka.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.kafka.telemetry.event.HubEventAvro;

import java.time.Instant;

@RestController
@RequestMapping("/events")
public class HubController {

    private final KafkaProducerService kafkaProducerService;

    public HubController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Обработчик событий хабов.
     *
     * @param request Входящие данные события хаба в формате JSON.
     * @return HTTP-ответ.
     */
    @PostMapping("/hubs")
    public ResponseEntity<Void> collectHubEvent(@RequestBody HubEventRequest request) {
        // Преобразование JSON-запроса в Avro-объект
        HubEventAvro avroEvent = convertToAvro(request);

        // Отправка события в Kafka
        kafkaProducerService.sendToKafka("telemetry.hubs.v1", avroEvent);

        return ResponseEntity.ok().build();
    }

    /**
     * Преобразование JSON-запроса в Avro-объект.
     *
     * @param request JSON-запрос.
     * @return Avro-объект HubEventAvro.
     */
    private HubEventAvro convertToAvro(HubEventRequest request) {
        HubEventAvro avroEvent = new HubEventAvro();
        avroEvent.setHubId(request.getHubId());
        avroEvent.setTimestamp(Instant.parse(request.getTimestamp()).toEpochMilli());
        avroEvent.setPayload(request.getPayload());
        return avroEvent;
    }
}
