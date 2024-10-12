package com.gvm.task_manager.service;

import com.gvm.task_manager.model.User;
import com.gvm.task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    User get(String nickname);

    void add(User user);

    void update(User user);

    void remove(String nickname);

    List<User> getAll();
}
