package com.playground.usermodule.exception;

/**
 * PatientNotFoundException is thrown to indicate that user does not exist in database
 *
 * @author thilak
 * @created 12/4/20
 */
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("User not found");
    }

}
