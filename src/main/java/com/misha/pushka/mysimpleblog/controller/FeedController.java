package com.misha.pushka.mysimpleblog.controller;

import com.misha.pushka.mysimpleblog.dto.FeedResponse;
import com.misha.pushka.mysimpleblog.dto.SubscriptionGetDto;
import com.misha.pushka.mysimpleblog.service.SubscriptionService;
import com.misha.pushka.mysimpleblog.service.TwitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final TwitService twitService;
    private final SubscriptionService subscriptionService;

    @GetMapping("v1/{userId}/feed")
    public FeedResponse getFeed(@PathVariable("userId") UUID userId, @RequestParam int page, @RequestParam int size) {
        List<SubscriptionGetDto> subscriptions = subscriptionService.getSubscriptions(userId);
        return twitService.getFeed(subscriptions.stream().map(SubscriptionGetDto::getSubscriptionId).toList(), page, size);
    }
}
