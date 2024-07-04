package com.misha.pushka.mysimpleblog.service;

import com.misha.pushka.mysimpleblog.dto.UserCreateDto;
import com.misha.pushka.mysimpleblog.dto.UserGetDto;
import com.misha.pushka.mysimpleblog.model.User;
import com.misha.pushka.mysimpleblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper userMapper;

    public void createUser(UserCreateDto user) {
        User user1 = userMapper.map(user, User.class);
        user1.setCreatedAt(LocalDateTime.now());
        userRepository.save(
                user1);
    }

    public List<UserGetDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.map(user, UserGetDto.class)).toList();
    }
}
