package com.example.Exception;

public class InvalidMoveException extends RuntimeException {
   // REVISION: Revise how to declare an exception class
    public InvalidMoveException(String message) {
        super(message);
    }
}
