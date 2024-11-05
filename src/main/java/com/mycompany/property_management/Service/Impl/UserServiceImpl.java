package com.mycompany.property_management.Service.Impl;

import com.mycompany.property_management.Converter.UserConverter;
import com.mycompany.property_management.DTO.Entity.UserEntity;
import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.Repository.UserRepository;
import com.mycompany.property_management.Service.UserService;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> oue=userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(oue.isPresent())
        {
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("Please enter a unique email");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        }
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        userEntity=userRepository.save(userEntity);
        userDTO=userConverter.convertEntitytoDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO=null;
        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmailAndPassword(email,password);
        if(optionalUserEntity.isPresent())
        {
            userDTO=userConverter.convertEntitytoDTO(optionalUserEntity.get());
        }
        else {
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Username/Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);

        }

        return userDTO;
    }
}
