package com.example.service.impl;

import com.example.model.Photo;
import com.example.model.Snap;
import com.example.model.User;
import com.example.model.dto.AddSnapDto;
import com.example.model.dto.GetSnapDto;
import com.example.repository.PhotoRepository;
import com.example.repository.SnapRepository;
import com.example.repository.UserRepository;
import com.example.service.SnapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 09.04.17.
 */
@Service
public class SnapServiceImpl implements SnapService {

    @Autowired
    private SnapRepository snapRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<GetSnapDto> findByReceiverId(Long id) {
        List<Snap> snaps = snapRepository.findByReceiverIdAndOpenedIsFalse(id);
        snaps.forEach(s -> s.setOpened(true));
        List<GetSnapDto> snapDtos = new ArrayList<>();
        for (Snap snap : snaps) {
            snapRepository.save(snap);
            User sender = userRepository.findOne(snap.getSenderId());
            Photo photo = photoRepository.findOne(snap.getPhotoId());
            GetSnapDto dto = new GetSnapDto(sender.getEmail(), photo.getImage());
            snapDtos.add(dto);
        }
        return snapDtos;
    }

    @Override
    public void saveSnapsForUsers(AddSnapDto addSnapDto) {
        Photo photo = new Photo(addSnapDto.getImage());
        photo = photoRepository.save(photo);

        User sender = userRepository.findByEmail(addSnapDto.getSenderEmail());

        Snap snap = new Snap();
        snap.setSenderId(sender.getId());
        snap.setPhotoId(photo.getId());
        snap.setOpened(false);

        for (String receiverEmail : addSnapDto.getReceiversEmails()) {
            User receiver = userRepository.findByEmail(receiverEmail);
            snap.setReceiverId(receiver.getId());
            snapRepository.save(snap);
        }
    }
}
