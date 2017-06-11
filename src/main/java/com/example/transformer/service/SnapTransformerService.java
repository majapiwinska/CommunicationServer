package com.example.transformer.service;

import com.example.model.Snap;
import com.example.model.dto.AddSnapDto;

/**
 * Created by maja on 02.05.17.
 */
public interface SnapTransformerService {

    AddSnapDto transformFromEntity(Snap entity);

    /**
     * @param dto
     * @return list of entites without: id, sender, receiver
     */
    Snap transformFromDto(AddSnapDto dto);

}
