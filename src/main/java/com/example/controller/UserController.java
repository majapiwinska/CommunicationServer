package com.example.controller;

import com.example.model.User;
import com.example.model.dto.BasicDto;
import com.example.model.dto.FriendDto;
import com.example.model.dto.UserDto;
import com.example.service.UserService;
import com.example.transformer.service.FriendTransformer;
import com.example.transformer.service.UserTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private FriendTransformer friendTransformer;


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

    @RequestMapping(value = "/addfriend/{id}", method = RequestMethod.PUT)
    public void addFriend(@PathVariable("id") Long id, @RequestBody BasicDto friendEmail){
        String userEmail = userService.findOne(id).getEmail();
        userService.addFriend(userEmail, friendEmail.getObject());
    }

    @RequestMapping(value = "/getfriends/{id}", method = RequestMethod.GET)
    public List<FriendDto> getFriends(@PathVariable("id") Long id){
        User user = userService.findOne(id);
        List<FriendDto> friends = friendTransformer.getFriendDtoList(user);
        return friends;
    }


}