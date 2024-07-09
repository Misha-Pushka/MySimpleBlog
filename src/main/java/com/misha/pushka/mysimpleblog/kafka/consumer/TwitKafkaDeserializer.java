package com.misha.pushka.mysimpleblog.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.misha.pushka.mysimpleblog.dto.TwitKafkaDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class TwitKafkaDeserializer implements Deserializer<TwitKafkaDto> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Никакой специфичной конфигурации не требуется
    }

    @Override
    public TwitKafkaDto deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, TwitKafkaDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize CustomObject", e);
        }
    }

    @Override
    public void close() {
        // Никаких ресурсов закрывать не нужно
    }
}
