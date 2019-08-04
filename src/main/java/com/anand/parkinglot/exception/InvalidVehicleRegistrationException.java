/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
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
