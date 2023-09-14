package com.example.rrprep3.service;

import com.example.rrprep3.model.View.PostViewModel;
import com.example.rrprep3.model.entity.User;
import com.example.rrprep3.model.service.PostServiceModel;
import com.example.rrprep3.model.service.UserServiceModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface PostService {
    void add(PostServiceModel postServiceModel, UserServiceModel userServiceModel);

    List<PostViewModel> findAllPostsByUser(String username);

    List<PostViewModel> findAllOtherPosts(String username);

    void removePost(String id);

    void likePost(String id, UserServiceModel userServiceModel);
}
