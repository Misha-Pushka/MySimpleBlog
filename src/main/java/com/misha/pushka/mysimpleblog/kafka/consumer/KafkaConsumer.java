package com.misha.pushka.mysimpleblog.kafka.consumer;

import com.misha.pushka.mysimpleblog.dto.SubscriptionGetDto;
import com.misha.pushka.mysimpleblog.dto.TwitGetDto;
import com.misha.pushka.mysimpleblog.dto.TwitKafkaDto;
import com.misha.pushka.mysimpleblog.redis.RedisService;
import com.misha.pushka.mysimpleblog.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final RedisService redisService;
    private final SubscriptionService subscriptionService;

    @KafkaListener(topics = "twits", groupId = "twit-service", containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload TwitKafkaDto twitKafkaDto, Acknowledgment ack) {
        System.out.println("twitKafkaDto = " + twitKafkaDto);
        List<SubscriptionGetDto> subscriptionGetDtoList = subscriptionService.getSubscribers(twitKafkaDto.getAuthorId());
        System.out.println("subscriptionGetDtoList = " + subscriptionGetDtoList);
        subscriptionGetDtoList.forEach(subscriptionGetDto -> redisService.saveToList(String.valueOf(subscriptionGetDto.getSubscriberId())
                , new TwitGetDto(twitKafkaDto.getId(), twitKafkaDto.getBody())));
        ack.acknowledge();
    }
}
