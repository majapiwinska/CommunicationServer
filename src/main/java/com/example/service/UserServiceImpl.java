package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user, Principal principal) {
        String email = principal.getName();
        User updatedUser = userRepository.findUserByEmail(email);
        List<User> friendsOf = new ArrayList<>();
        List<User> friends = new ArrayList<>();
        for(User friend : user.getFriendsOf()){
            friendsOf.add(friend);
        }
        for(User friend : user.getFriends()){
            friends.add(friend);
        }
        updatedUser.setFriends(friends);
        updatedUser.setFriendsOf(friendsOf);
        updatedUser.setEmail(user.getEmail());
        updatedUser.setNick(user.getNick());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);

    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
