package com.example.controller;

import com.example.service.SnapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maja on 09.04.17.
 */
@RestController
public class SnapController {

    @Autowired
    private SnapService snapService;
}

