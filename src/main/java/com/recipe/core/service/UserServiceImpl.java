package com.recipe.core.service;

import com.recipe.core.domain.User;
import com.recipe.core.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1NM30 on 05/08/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        List<UserEntity> usersEntities = userDao.findAll();
        for (UserEntity userEntity : usersEntities) {
            User user = new User();
            user.setName(userEntity.getName());
            user.setPassword(userEntity.getPassword());
            users.add(user);
        }
        return users;
    }

}
