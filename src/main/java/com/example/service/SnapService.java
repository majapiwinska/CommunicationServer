package com.example.service;

import com.example.model.Snap;

import java.util.List;

/**
 * Created by maja on 09.04.17.
 */
public interface SnapService {

    Snap findOne(Long id);

    List<Snap> findAll();

    List<Snap> findByReceiverId(Long id);

    Snap create(Snap snap);

    void delete(Long id);

}
