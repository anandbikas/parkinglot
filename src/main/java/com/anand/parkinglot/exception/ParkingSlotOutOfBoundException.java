package com.anand.parkinglot.exception;

public class ParkingSlotOutOfBoundException extends ArrayIndexOutOfBoundsException {

    /**
     *
     */
    public ParkingSlotOutOfBoundException() {
        super();
    }

    /**
     *
     * @param message
     */
    public ParkingSlotOutOfBoundException(String message) {
        super(message);
    }
}
