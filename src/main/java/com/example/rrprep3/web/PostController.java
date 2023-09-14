package com.example.rrprep3.web;

import com.example.rrprep3.bindning.PostAddBindingModel;
import com.example.rrprep3.model.service.PostServiceModel;
import com.example.rrprep3.model.service.UserServiceModel;
import com.example.rrprep3.service.PostService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
public class PostController {/*

    private UserServiceModel userServiceModel;
    private final PostService postService;
    private final ModelMapper modelMapper;

    public PostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){
        if(!model.containsAttribute("postAddBindingModel")){
            model.addAttribute("postAddBindingModel", new PostAddBindingModel());
        }
        return "post-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid PostAddBindingModel postAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             UserServiceModel usm) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:add";
        }

        postService.add(modelMapper.map(postAddBindingModel, PostServiceModel.class), userServiceModel);

        return "redirect:/";
    }*/
}
