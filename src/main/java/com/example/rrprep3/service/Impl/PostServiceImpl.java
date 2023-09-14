package com.example.rrprep3.service.Impl;

import com.example.rrprep3.model.View.PostViewModel;
import com.example.rrprep3.model.entity.Post;
import com.example.rrprep3.model.entity.User;
import com.example.rrprep3.model.service.PostServiceModel;
import com.example.rrprep3.model.service.UserServiceModel;
import com.example.rrprep3.repository.PostRepository;
import com.example.rrprep3.service.MoodService;
import com.example.rrprep3.service.PostService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    private final MoodService moodService;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(MoodService moodService, PostRepository postRepository, ModelMapper modelMapper) {
        this.moodService = moodService;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(PostServiceModel postServiceModel, UserServiceModel userServiceModel) {
        Post post = modelMapper.map(postServiceModel, Post.class);
        post.setMood(moodService.findByName(postServiceModel.getMood()));
        post.setUser(modelMapper.map(userServiceModel, User.class));
        List<User> userList = new ArrayList<>();
        post.setUserLikes(userList);
        postRepository.save(post);
    }

    @Override
    public List<PostViewModel> findAllPostsByUser(String username) {
        List<PostViewModel> userPosts = new ArrayList<>();

        postRepository.findAllByUser_Username(username)
                .forEach(post -> {

                    PostViewModel postViewModel = new PostViewModel();

                    postViewModel.setId(post.getId());
                    postViewModel.setContent(post.getContent());
                    postViewModel.setUsername(post.getUser().getUsername());
                    postViewModel.setLikes(post.getUserLikes().size());
                    postViewModel.setMoodName(post.getMood().getMoodName().name());

                    userPosts.add(postViewModel);
                });
        return userPosts;
    }
   @Override
    public List<PostViewModel> findAllOtherPosts(String username) {
        List<PostViewModel> userPosts = new ArrayList<>();

        postRepository.findAllByUserNameIsNot(username)
                .forEach(post -> {

                    PostViewModel postViewModel = new PostViewModel();

                    postViewModel.setId(post.getId());
                    postViewModel.setContent(post.getContent());
                    postViewModel.setUsername(post.getUser().getUsername());
                    postViewModel.setLikes(post.getUserLikes().size());
                    postViewModel.setMoodName(post.getMood().getMoodName().name());

                    userPosts.add(postViewModel);
                });
        return userPosts;
    }

    @Override
    public void removePost(String id) {
        postRepository.deleteById(id);
    }

    @Override
    public void likePost(String id, UserServiceModel userServiceModel) {
        Post post = postRepository.findById(id).orElse(null);
        post.getUserLikes().add(modelMapper.map(userServiceModel, User.class));
        postRepository.deleteById(id);
        postRepository.save(post);

    }
}
