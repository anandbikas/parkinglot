package com.anand.parkinglot.exception;

public class VehicleNotFoundException extends RuntimeException {

    /**
     *
     */
    public VehicleNotFoundException() {
        super();
    }

    /**
     *
     * @param message
     */
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
