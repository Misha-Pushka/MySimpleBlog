package com.misha.pushka.mysimpleblog.repository;

import com.misha.pushka.mysimpleblog.model.Twit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TwitRepository extends JpaRepository<Twit, UUID>, PagingAndSortingRepository<Twit, UUID> {
    List<Twit> findByUserId(UUID userId);
    List<Twit> findByUserIdIn(List<UUID> userId, Pageable pageable);
}
