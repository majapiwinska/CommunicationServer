package com.example.controller;

import com.example.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maja on 26.03.17.
 */
@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;
}
