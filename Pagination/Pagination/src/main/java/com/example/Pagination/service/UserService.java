package com.example.Pagination.service;

import com.example.Pagination.entity.User;
import com.example.Pagination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(int page,int size){
        return userRepository.findAll(PageRequest.of(page, size));
    }
}
