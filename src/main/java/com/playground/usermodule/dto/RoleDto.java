package com.playground.usermodule.dto;

import com.playground.usermodule.enums.UserRole;
import lombok.Data;

import java.util.UUID;

/**
 * RoleDto is the dto of Role Entity
 *
 * @author thilak
 * @created 12/4/20
 */
@Data
public class RoleDto {

    private UUID roleId;

    private UserRole role;

}
