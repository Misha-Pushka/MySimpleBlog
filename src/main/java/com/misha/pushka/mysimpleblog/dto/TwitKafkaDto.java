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
public class TwitKafkaDto {
    private UUID authorId;
    private UUID id;
    private String body;
}
