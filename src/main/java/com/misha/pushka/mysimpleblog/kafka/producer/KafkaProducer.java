package com.misha.pushka.mysimpleblog.kafka.producer;

import com.misha.pushka.mysimpleblog.dto.TwitKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "twits";

    private final KafkaTemplate<String, TwitKafkaDto> kafkaTemplate;

    public void sendMessage(TwitKafkaDto twitKafkaDto) {
        kafkaTemplate.send(TOPIC, twitKafkaDto);
    }
}
