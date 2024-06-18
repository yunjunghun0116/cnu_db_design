package com.junghun.con.domain.order.exception;

public class EmptyBasketException extends RuntimeException {

    public EmptyBasketException(String message) {
        super(message);
    }
}