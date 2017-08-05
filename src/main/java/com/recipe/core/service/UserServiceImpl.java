package com.recipe.core.service;

import com.recipe.core.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1NM30 on 05/08/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("m4r10");
        user.setPassword("p455w0rd");
        users.add(user);
        User user2 = new User();
        user2.setName("3dg4r");
        user2.setPassword("p455w0rd1");
        users.add(user2);
        return users;
    }
}
