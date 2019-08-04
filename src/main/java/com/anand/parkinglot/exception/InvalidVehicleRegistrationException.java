package com.anand.parkinglot.exception;

public class InvalidVehicleRegistrationException extends RuntimeException {

    /**
     *
     */
    public InvalidVehicleRegistrationException() {
        super();
    }

    /**
     *
     * @param message
     */
    public InvalidVehicleRegistrationException(String message) {
        super(message);
    }
}
