package com.anand.parkinglot.exception;

public class InvalidVehicleColorException extends RuntimeException {

    /**
     *
     */
    public InvalidVehicleColorException() {
        super();
    }

    /**
     *
     * @param message
     */
    public InvalidVehicleColorException(String message) {
        super(message);
    }
}
