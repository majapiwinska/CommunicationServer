package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * Created by maja on 10.04.17.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/android", method = RequestMethod.GET)
    public String getLoginView() {
        logger.info("Spring Android Basic Auth");
        return "home";
    }

    /*@RequestMapping(value = "/getmessage", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    User getMessage() {
        logger.info("Accessing protected resource");

    }
*/

}
