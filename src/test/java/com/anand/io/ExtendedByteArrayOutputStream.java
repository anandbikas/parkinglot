/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.io;

import java.io.ByteArrayOutputStream;

/**
 *
 */
public class ExtendedByteArrayOutputStream extends ByteArrayOutputStream {

    public byte [] getBuf(){
        return buf;
    }

    public ExtendedByteArrayOutputStream() {
        super();
    }

    public ExtendedByteArrayOutputStream(int size) {
        super(size);
    }
}
