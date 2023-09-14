package com.example.rrprep3.service;

import com.example.rrprep3.model.service.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findUserByNameAndPassword(String username, String password);
}
