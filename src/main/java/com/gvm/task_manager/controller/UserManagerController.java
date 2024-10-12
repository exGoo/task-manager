package com.gvm.task_manager.controller;

import com.gvm.task_manager.model.User;
import com.gvm.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/uManager")
public class UserManagerController {

    private final UserService userService;

    @Autowired
    public UserManagerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "userController/list_of_users";
    }

    @GetMapping("/user")
    public String getByNickname(@RequestParam(name = "nickname") String  nickName, Model model) {
        model.addAttribute("user", userService.get(nickName));
        return "userController/current_user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "userController/new_user";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/uManager";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "nickname") String nickName, Model model) {
        model.addAttribute("user", userService.get(nickName));
        return "userController/update_user";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/uManager";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "nickname") String nickname) {
        userService.remove(nickname);
        return "redirect:/uManager";
    }
}
