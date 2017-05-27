package com.example.controller;

import com.example.model.User;
import com.example.model.dto.FriendDto;
import com.example.model.dto.UserDto;
import com.example.service.UserService;
import com.example.transformer.service.UserTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransformerService userTransformerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UserDto createUser(@RequestBody UserDto dto) {
        System.out.println("Mamy sie");
        User user = userTransformerService.transformFromDto(dto);
        userService.create(user);
        dto.setId(user.getId());
        return dto;
    }
    @RequestMapping(value = "/hello", method = RequestMethod.PUT)
    public String sayHello(@RequestBody UserDto dto) {
        return "Hello from the server to " + dto.getName();
    }

    @RequestMapping(value = "/addfriend", method = RequestMethod.PUT)
    public UserDto addFriend(@RequestBody FriendDto friendDto){
        userService.addFriend(friendDto.getUserEmail(), friendDto.getFriendEmail());
        UserDto dto =userTransformerService.transformFromEntity(userService.findByEmail(friendDto.getUserEmail()));
        return dto;
    }

    @RequestMapping(value = "/getfriends", method = RequestMethod.GET)
    public List<UserDto> getFriends(UserDto dto){
        User user = userTransformerService.transformFromDto(dto);
        List<UserDto> friends = userTransformerService.transformListFromEntity(user);
        return friends;
    };


}