package com.misha.pushka.mysimpleblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "subscriptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User subscriber;

    @ManyToOne
    private User subscription;

    private Boolean showInFeed;

    public Subscription(UUID userId, UUID subscriptionId, boolean showInFeed) {
        this.subscriber = new User(userId);
        this.subscription = new User(subscriptionId);
        this.showInFeed = showInFeed;
    }
}
