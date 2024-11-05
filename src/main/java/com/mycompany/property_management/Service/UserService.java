package com.mycompany.property_management.Service;

import com.mycompany.property_management.DTO.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password );
}
