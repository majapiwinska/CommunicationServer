package com.example.transformer.service;

import com.example.model.Snap;
import com.example.model.dto.SnapDto;

import java.util.List;

/**
 * Created by maja on 02.05.17.
 */
public interface SnapTransformerService {

    SnapDto transformFromEntity(Snap entity);

    List<Snap> transformFromDtoToList(SnapDto dto);

}
