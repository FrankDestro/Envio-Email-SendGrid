package com.dev.send_grid.services.exceptions;

public class EmailException  extends RuntimeException{

    public EmailException(String msg) {
        super(msg);
    }
}
