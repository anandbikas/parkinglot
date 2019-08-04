package com.anand.parkinglot.exception;

public class DuplicateVehicleException extends RuntimeException {

    /**
     *
     */
    public DuplicateVehicleException() {
        super();
    }

    /**
     *
     * @param message
     */
    public DuplicateVehicleException(String message) {
        super(message);
    }
}
