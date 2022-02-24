package com.gryffindor.exceptions;

public class NotAManagerException extends Exception {
    public NotAManagerException() {
        super("This feature requires manager status");
    }
}