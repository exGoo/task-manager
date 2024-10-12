package com.gvm.task_manager.service;

import com.gvm.task_manager.model.User;
import com.gvm.task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(String nickname) {
        return userRepository.findById(nickname).orElse(null);
    }

    @Override
    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void remove(String nickname) {
        userRepository.deleteById(nickname);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
