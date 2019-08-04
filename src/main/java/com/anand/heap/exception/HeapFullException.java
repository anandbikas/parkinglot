/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.heap.exception;

public class HeapFullException extends RuntimeException {

    /**
     *
     */
    public HeapFullException() {
        super();
    }

    /**
     *
     * @param message
     */
    public HeapFullException(String message) {
        super(message);
    }
}
