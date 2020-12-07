package com.playground.usermodule.exception;

/**
 * DuplicateUserNameException is thrown to indicate that user name already exists in database
 *
 * @author thilak
 * @created 12/4/20
 */
public class DuplicateUserNameException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicateUserNameException() {
        super("Username already exists");
    }
}
