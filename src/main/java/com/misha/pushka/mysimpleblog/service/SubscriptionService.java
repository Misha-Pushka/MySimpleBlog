package com.misha.pushka.mysimpleblog.service;

import com.misha.pushka.mysimpleblog.dto.SubscriptionGetDto;
import com.misha.pushka.mysimpleblog.model.Subscription;
import com.misha.pushka.mysimpleblog.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final ModelMapper mapper;

    public void subscribe(UUID userId, UUID subscriptionId) {
        subscriptionRepository.save(new Subscription(userId, subscriptionId, true));
    }

    public List<SubscriptionGetDto> getSubscriptions(UUID userId) {
        return subscriptionRepository.findBySubscriberId(userId)
                .stream()
                .map(subscription -> mapper.map(subscription, SubscriptionGetDto.class))
                .toList();
    }

    public List<SubscriptionGetDto> getSubscribers(UUID userId) {
        return subscriptionRepository.findBySubscriptionId(userId)
                .stream()
                .map(subscription -> mapper.map(subscription, SubscriptionGetDto.class))
                .toList();
    }
}
