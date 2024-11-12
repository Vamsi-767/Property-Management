package com.mycompany.property_management.Controller;
import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
//RESTFULApi is just a mapping of a url to javaclass function
public class UserController {
    @Autowired
    private UserService userService;
    @Operation(description = "This method is used for user registration")
    @PostMapping("/register")
    public ResponseEntity register(@Parameter(name = "userDto", example = "user information", required = true)
            @Valid @RequestBody UserDTO userDTO)
    {
        userDTO= userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody UserDTO userDTO)
    {
        userDTO= userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
        ResponseEntity<UserDTO> responseEntity=new ResponseEntity<>(userDTO, HttpStatus.OK);
        return responseEntity;
    }
    @DeleteMapping("/{userid}")
    public  ResponseEntity<Void> deleteUser(@PathVariable Long userid)
    {
        userService.deleteUser(userid);
        ResponseEntity<Void> responseEntity=new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }

}
