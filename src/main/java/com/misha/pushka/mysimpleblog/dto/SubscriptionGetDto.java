package com.misha.pushka.mysimpleblog.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubscriptionGetDto {
    private UUID id;
    private UUID subscriberId;
    private UUID subscriptionId;
    private Boolean showInFeed;
}
