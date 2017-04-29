package com.example.transformer.service;

import com.example.model.User;
import com.example.model.dto.UserDto;

/**
 * Created by maja on 29.04.17.
 */
public interface UserTransformerService {

    User transformFromDto(UserDto dto);

    UserDto transformFromEntity(User entity);
}
