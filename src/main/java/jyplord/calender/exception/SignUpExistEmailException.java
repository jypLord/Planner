package jyplord.calender.exception;

public class SignUpExistEmailException extends RuntimeException {
    public SignUpExistEmailException(String message) {
        super(message);
    }
}
