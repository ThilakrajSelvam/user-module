package com.playground.usermodule.service;

import com.playground.usermodule.dto.UserDto;

import java.util.List;
import java.util.UUID;

/**
 * UserService provides the services for users
 *
 * @author thilak
 * @created 12/4/20
 */

public interface UserService {
    /**
     * Saves the patient details
     *
     * @param userDto
     * @return
     */
    UserDto createUser(UserDto userDto);

    /**
     * Retrieves the user details
     *
     * @param userId
     * @return
     */
    UserDto viewUser(UUID userId);

    /**
     * Updates the patient details
     *
     * @param userDto
     * @return
     */
    UserDto updateUser(UserDto userDto);

    /**
     * Deletes the patient details
     *
     * @param userId
     */
    void removeUser(UUID userId);

    /**
     * Retrieves all the patients details matching the given condition
     *
     * @param orderBy
     * @param page
     * @param recordsPerPage
     * @return
     */
    List<UserDto> getAllUsers(String orderBy, int page, int recordsPerPage);

    /**
     * Retrieves all the patients details matching the given condition
     *
     * @param text
     * @param orderBy
     * @param page
     * @param recordsPerPage
     * @return
     */
    List<UserDto> search(String text, String orderBy, int page, int recordsPerPage);

    /**
     * Retrieves Doctor Id
     *
     * @return
     */
    UUID getDoctorId();
}
