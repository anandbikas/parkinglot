package com.anand.parkinglot.exception;

public class ParkingFullException extends RuntimeException {

    /**
     *
     */
    public ParkingFullException() {
        super();
    }

    /**
     *
     * @param message
     */
    public ParkingFullException(String message) {
        super(message);
    }
}
