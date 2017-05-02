package com.example.controller;

import com.example.model.User;
import com.example.model.dto.UserDto;
import com.example.service.UserService;
import com.example.transformer.service.UserTransformerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * Created by maja on 10.04.17.
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransformerService userTransformerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto login(@RequestBody UserDto userDto){
        User user = userService.findByEmail(userDto.getEmail());
        if (user == null || !userDto.getPassword().equals(user.getPassword())) {
            return new UserDto();
        }
        return userTransformerService.transformFromEntity(user);
    }

}
