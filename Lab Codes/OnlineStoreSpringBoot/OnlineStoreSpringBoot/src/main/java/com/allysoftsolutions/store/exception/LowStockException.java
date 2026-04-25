package com.allysoftsolutions.store.exception;

/**
 * spring-task2 + spring-task6: Custom business exception
 */
public class LowStockException extends RuntimeException {
    public LowStockException(String message) {
        super(message);
    }
}