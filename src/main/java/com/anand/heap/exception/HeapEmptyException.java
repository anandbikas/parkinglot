/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
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
