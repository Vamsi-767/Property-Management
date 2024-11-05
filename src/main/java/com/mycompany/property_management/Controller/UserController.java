package com.mycompany.property_management.Controller;
import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
//RESTFULApi is just a mapping of a url to javaclass function
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO)
    {
        userDTO= userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO)
    {
        userDTO= userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.OK);
        return responseEntity;
    }

}
