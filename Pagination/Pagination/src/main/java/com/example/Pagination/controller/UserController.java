package com.example.Pagination.controller;

import com.example.Pagination.entity.User;
import com.example.Pagination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model
                           ,@RequestParam(value="page", defaultValue = "0") int page,
                           @RequestParam(value = "size", defaultValue = "5") int size) {

        Page<User> userPage = userService.getUsers(page, size);

        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());

    return "users";


    }

}
