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
