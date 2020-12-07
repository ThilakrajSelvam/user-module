package com.playground.usermodule.repository;

import com.playground.usermodule.entity.User;
import com.playground.usermodule.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * UserRepository provides methods to interact with database table
 *
 * @author thilak
 * @created 12/4/20
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT ur.user_id FROM user_roles ur WHERE ur.role_Id = ?1 limit 1", nativeQuery = true)
    UUID findUserIdByRoleId(String roleId);
}
