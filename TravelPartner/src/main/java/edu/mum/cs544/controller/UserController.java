package edu.mum.cs544.controller;


import edu.mum.cs544.bean.User;
import edu.mum.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "user/login"})
    public String showLoginForm(@ModelAttribute("user") User user) {
        return "th_user/loginForm";
    }

    @PostMapping("/user/login")
    public String processLogin(User user, Model model, HttpSession session, RedirectAttributes att) {
        User userLoggedIn = userService.userLogIn(user.getUsername(), user.getPassword());

        if (userLoggedIn==null){
            att.addFlashAttribute("error","No User for these Credentials");
            return "redirect:/user/login";

        }else {
            session.setAttribute("user", userLoggedIn);
            model.addAttribute("user", userLoggedIn);
//        model.addAttribute("userId", userLoggedIn.getId());
//        model.addAttribute("userName", userLoggedIn.getName());
//        model.addAttribute("userRole", userLoggedIn.getRole().toString());
            return "redirect:/bookings/user/" + userLoggedIn.getId();
        }
    }

    @GetMapping("/user/register")
    public String showRegisterForm(@ModelAttribute("user") User user) {
        return "th_user/registerForm";
    }

    @PostMapping("/user/register")
    public String processRegisterForm(@Valid User user, BindingResult result, Model model, HttpSession session) {

        if (result.hasErrors()){
            return "th_user/registerForm";
        }
        User registeredUser = userService.registerUser(user);

        model.addAttribute("user", registeredUser);
        session.setAttribute("user", user);

        model.addAttribute("userId", registeredUser.getId());
        model.addAttribute("userName", registeredUser.getName());
        model.addAttribute("userRole", registeredUser.getRole().toString());
        return "th_user/mainPage";
    }



    /** it may couse some rendering errors*/

    @GetMapping("/users")
    public String allUsers(Model model, HttpSession session) {
        List<User> users = userService.getAll();

        User user = (User) session.getAttribute("th_user");
        model.addAttribute("user", user);

        model.addAttribute("users", users);
        return "th_user/usersList";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateInfoForm(@ModelAttribute("user") User user, @PathVariable Integer id, Model model) {
        User currentUser = userService.get(id);
        model.addAttribute("user", currentUser);
        return "th_user/updateUserForm";
    }

    @PostMapping("/user/update/{id}")
    public String processUpdatedInfo(User user, Model model) {

        model.addAttribute("user", user);

        userService.update(user);
        return "th_user/mainPage";
    }

    @PostMapping(value = "/user/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/user/logout")
    public String logout(HttpSession session) {
        // session.removeAttribute("th_user");
        session.invalidate();
        return "th_user/loginForm";
    }

}
