package kafka;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, SpecificRecord> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, SpecificRecord> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Отправка сообщения в Kafka.
     *
     * @param topic Топик, в который отправляется сообщение.
     * @param event Объект Avro-сообщения.
     */
    public void sendToKafka(String topic, SpecificRecord event) {
        kafkaTemplate.send(topic, event).whenComplete((result, ex) -> {
            if (ex != null) {
                System.err.println("Failed to send message: " + ex.getMessage());
            } else {
                System.out.println("Message sent to topic: " + topic + " with offset: " + result.getRecordMetadata().offset());
            }
        });
    }
}
