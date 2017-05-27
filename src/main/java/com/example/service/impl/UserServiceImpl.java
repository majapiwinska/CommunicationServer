package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maja on 26.03.17.
 */
@Service
public class UserServiceImpl implements UserService {

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
        User updatedUser = userRepository.findByEmail(email);
        List<User> friendsOf = new ArrayList<>();
        List<User> friends = new ArrayList<>();
       /* for(User friend : user.getFriendsOf()){
            friendsOf.add(friend);
        }*/
        for(User friend : user.getFriends()){
            friends.add(friend);
        }
        updatedUser.setFriends(friends);
        //updatedUser.setFriendsOf(friendsOf);
        updatedUser.setEmail(user.getEmail());
        updatedUser.setNick(user.getNick());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);

    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User addFriend(String userEmail, String friendEmail) {
        User user = userRepository.findByEmail(userEmail);
        User friend = userRepository.findByEmail(friendEmail);

        if(friend != null && !user.getFriends().contains(friend)){
            user.getFriends().add(friend);
            friend.getFriends().add(user);
        } else {
            System.out.println("There's no such user!");
        }

        userRepository.save(user);
        userRepository.save(friend);
        return user;
    }


}
