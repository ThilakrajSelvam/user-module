package com.playground.usermodule.dto;

import com.playground.usermodule.enums.Gender;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

/**
 * UserDto is the dto of User Entity
 *
 * @author thilak
 * @created 12/4/20
 */
@Data
public class UserDto {

    private UUID userId;

    @Email
    @Size(max = 50, message = "Email should not be greater than 50 characters")
    private String email;

    @NotBlank
    @Size(max = 15, message = "Username should not be greater than 15 characters")
    private String userName;

    @Size(max = 50, message = "First Name should not be greater than 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last Name should not be greater than 50 characters")
    private String lastName;

    private Integer age;

    private Gender gender;

    @Size(max = 100, message = "Address Line 1 should not be greater than 100 characters")
    private String addressLine1;

    @Size(max = 100, message = "Address Line 2 should not be greater than 100 characters")
    private String addressLine2;

    @Size(max = 10, message = "Mobile No should not be greater than 10 characters")
    private String mobileNo;

    private List<RoleDto> roles;
}
