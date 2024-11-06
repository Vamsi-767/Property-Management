package com.mycompany.property_management.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message="This is mandatory field")
    @NotEmpty(message="This field cannot be empty")
    private String ownerEmail;
    private String phone;
    @NotNull(message="This is mandatory field")
    @NotEmpty(message="This field cannot be empty")
    @Size(min = 1,max = 14,message = "Length of the password should be between 1 to 14 characters")
    private String password;
}

