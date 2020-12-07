package com.playground.usermodule.repository;

import com.playground.usermodule.entity.Role;
import com.playground.usermodule.entity.User;
import com.playground.usermodule.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * RoleRepository provides methods to interact with database table
 *
 * @author thilak
 * @created 12/4/20
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role findByRole(UserRole userRole);
}
