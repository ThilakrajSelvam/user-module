package com.playground.usermodule.entity;

import com.playground.usermodule.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Role is a JPA Entity
 *
 * @author thilak
 * @created 12/4/20
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "role_mst")
public class Role {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID roleId;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private UserRole role;
}
