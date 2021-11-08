package ru.kpfu.itis.exceptions;

public class RedirectToValidUrlException extends Throwable {
    private String url;

    public RedirectToValidUrlException(String url) {
        //super("Should be redirect to " + url);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
