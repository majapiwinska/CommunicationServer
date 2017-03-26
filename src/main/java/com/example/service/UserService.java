package com.example.service;

import com.example.model.User;

import java.security.Principal;
import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
public interface UserService {

    User create(User user);

    User findOne(Long id);

    List<User> findAll();

    User update(User user, Principal principal);

    void delete(Long id);
}
