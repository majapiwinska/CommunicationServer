package com.example.controller;

import com.example.model.dto.SnapDto;
import com.example.service.SnapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maja on 09.04.17.
 */

@RestController
public class SnapController {

    @Autowired
    private SnapService snapService;

    @RequestMapping(value = "/sendsnap", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String sendSnap(@RequestBody SnapDto snapDto){
        System.out.println(snapDto.getImage());
        System.out.println(snapDto.getSenderEmail());
        return "{\"key\": \"jest snap\"}";

    }
}

