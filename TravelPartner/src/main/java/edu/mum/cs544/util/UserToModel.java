package edu.mum.cs544.util;

import edu.mum.cs544.bean.User;
import org.springframework.ui.Model;

public class UserToModel {

    public static void setUserToModel(Model model, User user){
        model.addAttribute("user", user);
    }
}
