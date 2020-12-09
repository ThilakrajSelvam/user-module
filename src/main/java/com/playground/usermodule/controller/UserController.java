package com.playground.usermodule.controller;

import com.playground.usermodule.dto.UserDto;
import com.playground.usermodule.service.UserService;
import io.micrometer.core.instrument.Timer;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * UserController provides rest endpoints of user details
 *
 * @author thilak
 * @created 12/4/20
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final Timer createUserTimer;


    /**
     * Saves the user details
     *
     * @param userDto
     * @return ResponseEntity
     */
    @PostMapping
    @ApiOperation(value = "Creates new User and returns the user details")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDto createUser(@RequestBody UserDto userDto) throws Exception {
        return createUserTimer.recordCallable(() -> userService.createUser(userDto));
    }

    /**
     * Retrieves the user details
     *
     * @param userId
     * @return ResponseEntity
     */
    @GetMapping(path = "/{userId}")
    @ApiOperation(value = "View the User details")
    public UserDto viewUser(@PathVariable UUID userId) {
        return userService.viewUser(userId);
    }

    /**
     * Updates the user details
     *
     * @param userDto
     * @return
     */
    @PutMapping
    @ApiOperation(value = "Update the user details")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    /**
     * Deletes the patient details
     *
     * @param userId
     * @return
     */
    @DeleteMapping(path = "/{userId}")
    @ApiOperation(value = "Deletes the user details")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable UUID userId) {
        userService.removeUser(userId);
    }

    /**
     * Retrieves all the patients details matching the given condition
     *
     * @param orderBy
     * @param page
     * @return
     */
    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(name = "orderby", defaultValue = "email") String orderBy,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "recordsperpage", defaultValue = "10") int recordsPerPage) {
        return userService.getAllUsers(orderBy, page, recordsPerPage);
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
    @GetMapping("/search")
    public List<UserDto> search(
            @RequestParam(name = "text") String text,
            @RequestParam(name = "orderby", defaultValue = "email") String orderBy,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "recordsperpage", defaultValue = "10") int recordsPerPage) {
        return userService.search(text, orderBy, page, recordsPerPage);

    }

    /**
     * Retrieves the Doctor Id
     *
     * @return
     */
    @GetMapping(path = "/userid")
    public UUID getUserId() {
        return userService.getDoctorId();
    }

}
