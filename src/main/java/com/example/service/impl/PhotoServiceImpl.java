package com.example.service.impl;

import com.example.model.Photo;
import com.example.repository.PhotoRepository;
import com.example.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
   private PhotoRepository photoRepository;

    @Override
    public Photo create(Photo photo) {
        return photoRepository.save(photo);

    }

    @Override
    public Photo findOne(Long id) {
        return photoRepository.findOne(id);
    }

    @Override
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        photoRepository.delete(id);
    }
}
