package edu.mum.cs544.controller;

import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
//@SessionAttributes(value={"userId", "name", "userRole"})
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public String goToLogIn(){
//
//    }

    @GetMapping(value = {"/","user/login"})
    public String showLoginForm(@ModelAttribute("user") User user) {
        return "user/loginForm";
    }

    @PostMapping("/user/login")
    public String processLogin(User user, Model model, HttpSession session){
        User userLoggedIn = userService.userLogIn(user.getUsername(), user.getPassword());

        session.setAttribute("user", userLoggedIn);
        model.addAttribute("user", userLoggedIn);
//        model.addAttribute("userId", userLoggedIn.getId());
//        model.addAttribute("userName", userLoggedIn.getName());
//        model.addAttribute("userRole", userLoggedIn.getRole().toString());
        return "user/mainPage";
    }

    @GetMapping("/user/register")
    public String showRegisterForm(@ModelAttribute("user") User user ){
        return "user/registerForm";
    }

    @PostMapping("/user/register")
    public String processRegisterForm(User user, Model model){
            User registeredUser = userService.registerUser(user);
            model.addAttribute("userId", registeredUser.getId());
            model.addAttribute("userName", registeredUser.getName());
            model.addAttribute("userRole", registeredUser.getRole().toString());
            return "user/mainPage";
    }

    @GetMapping("/users")
    public String allUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "user/usersList";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateInfoForm(@ModelAttribute("user") User user, @PathVariable Integer id, Model model){
        User currentUser = userService.get(id);
        model.addAttribute("user", currentUser);
        return "user/updateUserForm";
    }

    @PostMapping("/user/update/{id}")
    public String processUpdatedInfo(User user ){
        userService.update(user);
        return "user/mainPage";
    }
//    @GetMapping("/users/delete/{id}")
//    public String showDeleteForm(@PathVariable int id, Model model) {
//        //model.addAttribute("user", userService.find(id));
//        return "deleteUserForm";
//    }

    @PostMapping(value = "/user/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/user/logout")
    public String logout(SessionStatus sessionStatus){

        sessionStatus.setComplete();
        return "loginForm";
    }

}
