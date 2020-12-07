package com.playground.usermodule;

import com.playground.usermodule.enums.Gender;
import com.playground.usermodule.enums.UserRole;
import com.playground.usermodule.repository.RoleRepository;
import com.playground.usermodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.transaction.Transactional;
import java.util.UUID;

@SpringBootApplication
@EnableSwagger2
public class UserModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserModuleApplication.class, args);
    }

}
