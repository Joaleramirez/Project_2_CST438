package com.example.api.service;

import com.example.api.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users;

    public UserService(){
        users = new ArrayList<User>();

        User user = new User(1, "Ida", "ida@mail.com");
        User user2 = new User(2, "Max", "max@mail.com");
        User user3 = new User(3, "Jack", "jack@mail.com");

        users.addAll(Arrays.asList(user, user2, user3));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();

        for(User user: users) {
            if(user.getId() == id) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
