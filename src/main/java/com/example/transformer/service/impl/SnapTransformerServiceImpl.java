package com.example.transformer.service.impl;

import com.example.model.Snap;
import com.example.model.dto.SnapDto;
import com.example.transformer.service.SnapTransformerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 27.05.17.
 */
@Service
public class SnapTransformerServiceImpl implements SnapTransformerService {


    @Override
    public SnapDto transformFromEntity(Snap entity) {
        SnapDto dto = new SnapDto();
/*        List<Long> receiversList = new ArrayList<>();
        receiversList.add(entity.getReceiverId());

        dto.setSenderId(entity.getSender().getId());
        dto.setReceiversList(receiversList);
        dto.setImage(photoService.findOne(entity.getPhoto().getId()).getImage());
        dto.setSeconds(entity.getSeconds());
        dto.setOpened(false);*/
        return dto;
    }

    @Override
    public Snap transformFromDto(SnapDto dto) {
        Snap entity = new Snap();
//        entity.se
        return entity;
    }


}