package com.example.service.impl;

import com.example.model.Snap;
import com.example.repository.SnapRepository;
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
}
