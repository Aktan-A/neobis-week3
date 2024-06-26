package com.store.api.service;

import com.store.api.dto.UserDto;
import com.store.api.exception.ResourceNotFoundException;
import com.store.api.mapper.UserMapper;
import com.store.api.model.User;
import com.store.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User with id " + id + " does not exist.");
        }
        return UserMapper.convertEntityToDto(user.get());
    }

    public UserDto getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User with username " + username + " does not exist.");
        }
        return UserMapper.convertEntityToDto(user.get());
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void deleteUserById(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new ResourceNotFoundException("User with id " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }

    public UserDto updateUserById(Long userId, UserDto userDto) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User with id " + userId + " does not exist.");
        }
        User userModel = user.get();
        userModel.setFirstName(userDto.getFirstName());
        userModel.setLastName(userDto.getLastName());
        userModel.setAddress(userDto.getAddress());

        return UserMapper.convertEntityToDto(userRepository.save(userModel));
    }

}
