package com.spring.first.api.spring_first_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.first.api.spring_first_api.dto.UserCampusDTO;
import com.spring.first.api.spring_first_api.dto.UserRoleView;
import com.spring.first.api.spring_first_api.dto.UserShortInfoView;
import com.spring.first.api.spring_first_api.model.User;
import com.spring.first.api.spring_first_api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByUserUsername(String username) {
        return userRepository.findByUserUsername(username);
    }

    @Override
    public Optional<UserRoleView> findProjectedByUserUsername(String username) {
        return userRepository.findProjectedByUserUsername(username);
    }

    @Override
    public List<UserCampusDTO> findAllUserCampus() {
       return userRepository.findAllUserCampus();
    }

    @Override
    public List<UserShortInfoView> sp_getUserById(Integer userId) {
        return userRepository.sp_getUserById(userId);
    }

}
