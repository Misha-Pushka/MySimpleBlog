package com.misha.pushka.mysimpleblog.controller;

import com.misha.pushka.mysimpleblog.dto.SubscriptionGetDto;
import com.misha.pushka.mysimpleblog.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/user/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{userId}/subscribe/{subscriptionId}")
    public void subscribe(@PathVariable UUID userId, @PathVariable UUID subscriptionId) {
        subscriptionService.subscribe(userId, subscriptionId);
    }

    @GetMapping("/{userId}/getSubscriptions")
    public List<SubscriptionGetDto> getSubscriptions(@PathVariable UUID userId) {
        return subscriptionService.getSubscriptions(userId);
    }
    @GetMapping("/{userId}/getSubscribers")
    public List<SubscriptionGetDto> getSubscribers(@PathVariable UUID userId) {
        return subscriptionService.getSubscribers(userId);
    }
}
