package com.misha.pushka.mysimpleblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionGetDto {
    private UUID id;
    private UUID subscriberId;
    private UUID subscriptionId;
    private Boolean showInFeed;
}
