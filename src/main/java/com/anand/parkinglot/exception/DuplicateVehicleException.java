/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
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
