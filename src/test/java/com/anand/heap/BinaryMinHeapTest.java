package com.anand.heap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class BinaryMinHeapTest {

    private  BinaryMinHeap<Integer> binaryMinHeap;

    @BeforeMethod
    private void setup(){
        binaryMinHeap = new BinaryMinHeap<>();
    }

    @Test
    private void binaryMinHeap(){

        binaryMinHeap.insert(5);
        binaryMinHeap.insert(4);
        binaryMinHeap.insert(2);
        binaryMinHeap.insert(3);
        binaryMinHeap.insert(6);


        // Heap now: 2, 3, 4, 5, 6
        binaryMinHeap.replace(2, 1);

        // Heap now: 1, 3, 2, 5, 6
        binaryMinHeap.delete(1);

        // Heap now: 1, 5, 2, 6
        binaryMinHeap.display();

        Assert.assertEquals((int)binaryMinHeap.extractMin(), 1);

        // Heap now: 2, 5, 6
        binaryMinHeap.display();

    }
}
