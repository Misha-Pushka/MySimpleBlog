package com.misha.pushka.mysimpleblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetDto {
    private UUID id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private List<TwitGetDto> twits;
}
