package com.my.SpringSecutity.SpringRest.Error;

public class ErrorMessage {
    private String message;
    private long time;

    public ErrorMessage() {
    }
    public ErrorMessage(String massahe,long time) {
    this.message=massahe;
    this.time=time;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return message+time;
    }
}
