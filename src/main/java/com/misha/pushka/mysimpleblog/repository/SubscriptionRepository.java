package com.misha.pushka.mysimpleblog.repository;

import com.misha.pushka.mysimpleblog.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    List<Subscription> findBySubscriptionIdAndShowInFeedTrue(UUID uuid);

    List<Subscription> findBySubscriberId(UUID subscriberId);

    List<Subscription> findBySubscriptionId(UUID userId);
}
