package com.example.controller;

import com.example.model.Snap;
import com.example.model.dto.AddSnapDto;
import com.example.model.dto.GetSnapDto;
import com.example.service.SnapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 09.04.17.
 */

@RestController
public class SnapController {

    @Autowired
    SnapService snapService;

    @RequestMapping(
            value = "/sendsnap",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    public void sendSnap(@RequestBody AddSnapDto addSnapDto){
        snapService.saveSnapsForUsers(addSnapDto);
    }

    @RequestMapping(
            value = "/getsnaps/{id}",
            method = RequestMethod.GET
    )
    public List<GetSnapDto> getSnaps(@PathVariable("id") Long receiverId){
        List<GetSnapDto> snaps = snapService.findByReceiverId(receiverId);
        return snaps;
    };

}

