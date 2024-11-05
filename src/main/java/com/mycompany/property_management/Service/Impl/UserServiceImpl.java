package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.UserConverter;
import com.mycompany.property_management.DTO.Entity.UserEntity;
import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.Repository.UserRepository;
import com.mycompany.property_management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        userEntity=userRepository.save(userEntity);
        userDTO=userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
