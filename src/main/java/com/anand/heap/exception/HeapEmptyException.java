package com.anand.heap.exception;

public class HeapEmptyException extends RuntimeException {

    /**
     *
     */
    public HeapEmptyException() {
        super();
    }

    /**
     *
     * @param message
     */
    public HeapEmptyException(String message) {
        super(message);
    }
}
