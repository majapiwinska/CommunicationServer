package com.example.transformer.service.impl;

import com.example.model.User;
import com.example.model.dto.UserDto;
import com.example.service.UserService;
import com.example.transformer.service.UserTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by maja on 29.04.17.
 */
@Service
public class UserTransformerServiceImpl implements UserTransformerService {

   @Autowired
   UserService userService;

    @Override
    public User transformFromDto(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setNick(dto.getNick());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFriends(new ArrayList<>());
        user.setFriendsOf(new ArrayList<>());
        user.setPhotos(new ArrayList<>());
        return user;
    }

    @Override
    public UserDto transformFromEntity(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setName(entity.getName());
        userDto.setSurname(entity.getSurname());
        userDto.setNick(entity.getNick());
        userDto.setEmail(entity.getEmail());
        userDto.setPassword(entity.getPassword());
        return userDto;
    }
}
