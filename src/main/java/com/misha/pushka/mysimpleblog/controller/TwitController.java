package com.misha.pushka.mysimpleblog.controller;

import com.misha.pushka.mysimpleblog.dto.TwitCreateDto;
import com.misha.pushka.mysimpleblog.dto.TwitGetDto;
import com.misha.pushka.mysimpleblog.kafka.producer.KafkaProducer;
import com.misha.pushka.mysimpleblog.model.Twit;
import com.misha.pushka.mysimpleblog.redis.RedisService;
import com.misha.pushka.mysimpleblog.service.TwitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/twit")
@RequiredArgsConstructor
public class TwitController {

    private final TwitService twitService;
    private final RedisService redisService;

    @PostMapping("/create")
    public void createTwit(@RequestBody TwitCreateDto twit) {
        twitService.createTwit(twit);
    }

    @GetMapping("/{userId}/twits")
    public List<TwitGetDto> getTwitsByUser(@PathVariable UUID userId) {
        return redisService.findList(String.valueOf(userId));
    }
}
