package com.playground.usermodule.serviceimpl;

import com.playground.usermodule.dto.UserDto;
import com.playground.usermodule.entity.User;
import com.playground.usermodule.enums.UserRole;
import com.playground.usermodule.exception.DuplicateEmailException;
import com.playground.usermodule.exception.DuplicateUserNameException;
import com.playground.usermodule.exception.UserNotFoundException;
import com.playground.usermodule.repository.RoleRepository;
import com.playground.usermodule.repository.UserRepository;
import com.playground.usermodule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author thilak
 * @created 12/7/20
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final RoleRepository roleRepository;

    /**
     * Saves the patient details
     *
     * @param userDto
     * @return
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);

        if (userRepository.existsByEmail(userEntity.getEmail()))
            throw new DuplicateEmailException();

        else if (userRepository.existsByUserName(userEntity.getUserName()))
            throw new DuplicateUserNameException();

        userEntity = userRepository.save(userEntity);
        userDto = modelMapper.map(userEntity, UserDto.class);

        return userDto;
    }

    /**
     * Retrieves the user details
     *
     * @param userId
     * @return
     */
    @Override
    public UserDto viewUser(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())
            throw new UserNotFoundException();
        return modelMapper.map(user.get(), UserDto.class);
    }

    /**
     * Updates the patient details
     *
     * @param userDto
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    /**
     * Deletes the patient details
     *
     * @param userId
     */
    @Override
    public void removeUser(UUID userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException();
        }
    }

    /**
     * Retrieves all the patients details matching the given condition
     *
     * @param orderBy
     * @param page
     * @param recordsPerPage
     * @return
     */
    @Override
    public List<UserDto> getAllUsers(String orderBy, int page, int recordsPerPage) {
        Pageable pageable = PageRequest.of(page, recordsPerPage, Sort.by(orderBy).ascending());
        List<User> users = userRepository.findAll(pageable).toList();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all the patients details matching the given condition
     *
     * @param text
     * @param orderBy
     * @param page
     * @param recordsPerPage
     * @return
     */
    @Override
    public List<UserDto> search(String text, String orderBy, int page, int recordsPerPage) {
        Pageable pageable = PageRequest.of(page, recordsPerPage, Sort.by(orderBy).ascending());
        User user = new User();
        user.setEmail(text);
        user.setUserName(text);
        user.setFirstName(text);
        user.setLastName(text);
        user.setMobileNo(text);
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("email", match -> match.contains())
                .withMatcher("userName", match -> match.contains())
                .withMatcher("firstName", match -> match.contains())
                .withMatcher("lastName", match -> match.contains())
                .withMatcher("mobileNo", match -> match.contains());
        Example<User> example = Example.of(user, matcher);
        List<User> users = userRepository.findAll(example, pageable).toList();
        return users.stream().map(userEntity -> modelMapper.map(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves Doctor Id
     *
     * @return
     */
    @Override
    public UUID getDoctorId() {
        String roleId = roleRepository.findByRole(UserRole.DOCTOR).getRoleId().toString();
        return userRepository.findUserIdByRoleId(roleId);
    }

}
