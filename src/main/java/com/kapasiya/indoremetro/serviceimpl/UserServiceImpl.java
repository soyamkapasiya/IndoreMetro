package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.User;
import com.kapasiya.indoremetro.repo.UserRepository;
import com.kapasiya.indoremetro.servicedefinitation.UserService;

import java.util.List;

public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user)
    {
        // Additional validation or business logic can be added here
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        // Additional validation or business logic can be added here
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
