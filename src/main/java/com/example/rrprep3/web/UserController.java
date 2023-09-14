package com.example.rrprep3.web;

import com.example.rrprep3.bindning.PostAddBindingModel;
import com.example.rrprep3.bindning.UserLoginBindingModel;
import com.example.rrprep3.bindning.UserRegisterBindingModel;
import com.example.rrprep3.model.entity.User;
import com.example.rrprep3.model.service.PostServiceModel;
import com.example.rrprep3.model.service.UserServiceModel;
import com.example.rrprep3.service.PostService;
import com.example.rrprep3.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private UserServiceModel userServiceModel;
    private final PostService postService;


    public UserController(UserService userService, ModelMapper modelMapper, PostService postService) {

        this.userService = userService;
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @GetMapping("/users/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }



        return "register";
    }

    @PostMapping("/users/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
        userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";

    }

    @GetMapping("/users/login")
    public String login(Model model){
        if(!model.containsAttribute("userLoginBindingModel")){
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("NotFound", false);
        }
        return "login";
    }

    @PostMapping("/users/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", new UserLoginBindingModel());
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }
         userServiceModel = userService.findUserByNameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());
        if(userServiceModel == null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", new UserLoginBindingModel());
            redirectAttributes.addFlashAttribute("NotFound", true);
            return "redirect:login";
        }

        httpSession.setAttribute("user", userServiceModel);

        return "redirect:/";

    }
    @GetMapping("/users/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "index";
    }
    @GetMapping("/posts/add")
    public String add(Model model){
        if(!model.containsAttribute("postAddBindingModel")){
            model.addAttribute("postAddBindingModel", new PostAddBindingModel());
        }
        return "post-add";
    }
    @PostMapping("posts/add")
    public String addConfirm(@Valid PostAddBindingModel postAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:add";
        }

        postService.add(modelMapper.map(postAddBindingModel, PostServiceModel.class), userServiceModel);

        return "redirect:/";

    }
    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("userPosts", postService.findAllPostsByUser(userServiceModel.getUsername()));
        model.addAttribute("otherPosts", postService.findAllOtherPosts(userServiceModel.getUsername()));

        return  "home";
    }
    @GetMapping("posts/remove/{id}")
    public String removePost(@PathVariable String id){
        postService.removePost(id);
        return "redirect:/";
    }
    @GetMapping("posts/like/{id}")
    public String likePost(@PathVariable String id){
        postService.likePost(id, userServiceModel);
        return "redirect:/";
    }


}
