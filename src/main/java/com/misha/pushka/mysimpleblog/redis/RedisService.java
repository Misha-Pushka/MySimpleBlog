package com.misha.pushka.mysimpleblog.redis;

import com.misha.pushka.mysimpleblog.dto.TwitGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, TwitGetDto> redisTemplate;


    public void saveToList(String key, TwitGetDto value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    public List<TwitGetDto> findList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public void deleteList(String key) {
        redisTemplate.delete(key);
    }
}
