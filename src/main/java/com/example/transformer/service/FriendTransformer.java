package com.example.transformer.service;

import com.example.model.User;
import com.example.model.dto.FriendDto;

import java.util.List;

/**
 * Created by maja on 31.05.17.
 */
public interface FriendTransformer {

    List<FriendDto> getFriendDtoList(User user);

}
