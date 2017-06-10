package com.example.service.impl;

import com.example.model.Photo;
import com.example.model.Snap;
import com.example.model.User;
import com.example.model.dto.SnapDto;
import com.example.repository.PhotoRepository;
import com.example.repository.SnapRepository;
import com.example.repository.UserRepository;
import com.example.service.PhotoService;
import com.example.service.SnapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Snap findOne(Long id) {
        return snapRepository.findOne(id);
    }

    @Override
    public List<Snap> findAll() {
       return snapRepository.findAll();
    }

    @Override
    public List<Snap> findByReceiverId(Long id) {
        return snapRepository.findByReceiverId(id);
    }

    @Override
    public Snap create(Snap snap) {
        return snapRepository.save(snap);
    }

    @Override
    public void delete(Long id) {
        snapRepository.delete(id);
    }

    @Override
    public void saveSnapsForUsers(SnapDto snapDto) {
        // save photo
        Photo photo = new Photo(snapDto.getImage());
        photo = photoRepository.save(photo);

        // get sender
        User sender = userRepository.findOne(snapDto.getSenderId());

        // build entity
        Snap snap = new Snap();
        snap.setSender(sender);
        snap.setPhoto(photo);

        // save a snap for each user
        for (Long receiverId : snapDto.getReceiversList()) {
            User receiver = userRepository.findOne(receiverId);
            snap.setReceiver(receiver);
            snapRepository.save(snap);
        }
    }
}
