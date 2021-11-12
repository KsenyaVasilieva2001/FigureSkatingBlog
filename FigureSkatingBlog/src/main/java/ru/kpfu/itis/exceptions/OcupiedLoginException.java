package ru.kpfu.itis.exceptions;

public class OcupiedLoginException extends RuntimeException{
    public OcupiedLoginException() {
    }

    public OcupiedLoginException(String message) {
        super(message);
    }

    public OcupiedLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcupiedLoginException(Throwable cause) {
        super(cause);
    }
}
