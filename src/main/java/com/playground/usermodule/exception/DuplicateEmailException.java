package com.playground.usermodule.exception;

/**
 * DuplicateEmailException is thrown to indicate that email already exists in database
 *
 * @author thilak
 * @created 12/4/20
 */
public class DuplicateEmailException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicateEmailException() {
        super("Email Already Exists");
    }
}
