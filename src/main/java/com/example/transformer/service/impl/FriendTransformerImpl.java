package com.example.transformer.service.impl;

import com.example.model.User;
import com.example.model.dto.FriendDto;
import com.example.transformer.service.FriendTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by maja on 31.05.17.
 */
@Service
public class FriendTransformerImpl implements FriendTransformer {


    @Override
    public List<FriendDto> getFriendDtoList(User user) {
        return user.getFriends().stream().map(this::transformToFriendDto).collect(Collectors.toList());
    }

    private FriendDto transformToFriendDto(User user){
        return new FriendDto(user.getId(), user.getNick(), user.getEmail());
    }
}
