package com.misha.pushka.mysimpleblog.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TwitGetDto {
    private UUID id;
    private String body;
}
