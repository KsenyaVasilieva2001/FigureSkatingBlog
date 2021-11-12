package ru.kpfu.itis.exceptions;

public class NoConnectionToGoogleAccount extends Exception{
    public NoConnectionToGoogleAccount() {
    }

    public NoConnectionToGoogleAccount(String message) {
        super(message);
    }

    public NoConnectionToGoogleAccount(String message, Throwable cause) {
        super(message, cause);
    }

    public NoConnectionToGoogleAccount(Throwable cause) {
        super(cause);
    }
}
