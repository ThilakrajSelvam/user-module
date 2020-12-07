package com.playground.usermodule.dto;

import com.playground.usermodule.enums.Gender;
import lombok.Data;

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

    private String email;

    private String userName;

    private String firstName;

    private String lastName;

    private Integer age;

    private Gender gender;

    private String addressLine1;

    private String addressLine2;

    private String mobileNo;

    private List<RoleDto> roles;
}
