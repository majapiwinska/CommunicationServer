package com.example.transformer.service.impl;

import com.example.model.Photo;
import com.example.model.Snap;
import com.example.model.dto.SnapDto;
import com.example.service.PhotoService;
import com.example.service.SnapService;
import com.example.service.UserService;
import com.example.transformer.service.SnapTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 27.05.17.
 */
@Service
public class SnapTransformerServiceImpl implements SnapTransformerService {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private SnapService snapService;
    @Autowired
    private UserService userService;


    @Override
    public SnapDto transformFromEntity(Snap entity) {
        SnapDto dto = new SnapDto();
        List<String> receiversList = new ArrayList<>();
        receiversList.add(userService.findOne(entity.getId()).getEmail());
        dto.setSenderId(entity.getSenderId());
        dto.setReceiversList(receiversList);
        dto.setImage(photoService.findOne(entity.getPhotoId()).getImage());
        dto.setSeconds(entity.getSeconds());
        dto.setOpened(false);
        return dto;
    }

    @Override
    public List<Snap> transformFromDtoToList(SnapDto dto) {
        List<Snap> entities = new ArrayList<>();
        Photo photo = new Photo();
        photo.setImage(dto.getImage());
        photoService.create(photo);
        for (String receiverEmail : dto.getReceiversList()) {
            Snap entity = new Snap();
            entity.setSenderId(dto.getSenderId());
            entity.setReceiverId(userService.findByEmail(receiverEmail).getId());
            entity.setPhotoId(photo.getId());
            entity.setSeconds(dto.getSeconds());
            entity.setOpened(false);
            entities.add(entity);
            snapService.create(entity);
        }
        return entities;
    }


}