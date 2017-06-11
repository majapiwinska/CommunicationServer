package com.example.service;

import com.example.model.Snap;
import com.example.model.dto.AddSnapDto;
import com.example.model.dto.GetSnapDto;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by maja on 09.04.17.
 */
public interface SnapService {

    List<GetSnapDto> findByReceiverId(Long id);

    @Transactional
    void saveSnapsForUsers(AddSnapDto addSnapDto);

}
