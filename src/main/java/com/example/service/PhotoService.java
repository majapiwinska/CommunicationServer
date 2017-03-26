package com.example.service;

import com.example.model.Photo;

import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
public interface PhotoService {

    Photo create(Photo photo);

    Photo findOne(Long id);

    List<Photo> findAll();

    void delete(Long id);

}
