package com.springboot.rent.Service;

import com.springboot.rent.data.entity.User;
import com.springboot.rent.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findUserByName(String name){
        return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }
}
