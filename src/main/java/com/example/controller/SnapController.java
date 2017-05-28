package com.example.controller;

import com.example.model.Snap;
import com.example.model.dto.SnapDto;
import com.example.service.SnapService;
import com.example.transformer.service.SnapTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 09.04.17.
 */

@RestController
public class SnapController {

    @Autowired
    SnapTransformerService snapTransformerService;
    @Autowired
    SnapService snapService;

    @RequestMapping(
            value = "/sendsnap",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    public String sendSnap(@RequestBody SnapDto snapDto){
        snapTransformerService.transformFromDtoToList(snapDto);
        return "{\"key\": \"jest snap\"}";

    }

    @RequestMapping(
            value = "/getsnaps",
            method = RequestMethod.GET
    )
    public List<SnapDto> getSnaps(Long receiverId){
        List<Snap> entities = snapService.findByReceiverId(receiverId);
        List<SnapDto> dtoList = new ArrayList<>();
        for(Snap entity: entities){
            SnapDto dto = snapTransformerService.transformFromEntity(entity);
            dtoList.add(dto);
        }
        return dtoList;

    };

}

