/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
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
