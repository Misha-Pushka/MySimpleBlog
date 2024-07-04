package com.misha.pushka.mysimpleblog.service;

import com.misha.pushka.mysimpleblog.dto.FeedResponse;
import com.misha.pushka.mysimpleblog.dto.TwitCreateDto;
import com.misha.pushka.mysimpleblog.dto.TwitGetDto;
import com.misha.pushka.mysimpleblog.model.Twit;
import com.misha.pushka.mysimpleblog.repository.TwitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TwitService {
    private final TwitRepository twitRepository;
    private final ModelMapper twitMapper;

    public void createTwit(TwitCreateDto twit) {
        twitRepository.save(twitMapper.map(twit, Twit.class));
    }

    public List<TwitGetDto> getTwitsByUser(UUID userId) {
        return twitRepository.findByUserId(userId)
                .stream()
                .map(twit -> twitMapper.map(twit, TwitGetDto.class))
                .toList();
    }

    public FeedResponse getFeed(List<UUID> userId, int page, int size) {
//        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(page - 1, size);
        return new FeedResponse(twitRepository.findByUserIdIn(userId, pageable)
                .stream()
                .map(twit -> twitMapper.map(twit, TwitGetDto.class)).toList());
    }
}
