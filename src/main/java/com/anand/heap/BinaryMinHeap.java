/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.heap;

import com.anand.heap.exception.HeapEmptyException;
import com.anand.heap.exception.HeapFullException;

/**
 * A BinaryHeap is a complete BinaryTree.
 * (all levels completely filled except the last level where all the nodes are as left as possible).
 *
 * BinaryHeap can be a Min Heap or a Max Heap.
 *
 * In a BinaryMinHeap, the root node is the minimum for all the possible sub trees.
 *
 *            5                     10
 *        10    30            15        20
 *     20                  40   35   50   40
 *
 * Array represents level order traversal of the tree.
 *
 * @param <T>
 */
public class BinaryMinHeap<T extends Comparable<T>>{

    private static final int DEFAULT_SIZE = 100;

    private T [] heapArr;
    private int size=0;

    /**
     *
     */
    public BinaryMinHeap(){
        this(DEFAULT_SIZE);
    }

    /**
     *
     * @param size
     */
    @SuppressWarnings("unchecked")
    public BinaryMinHeap(int size){
        heapArr = (T[])new Comparable[size];
    }

    /**
     *
     * @param i
     * @return
     */
    private int left(int i){
        return 2*i+1;
    }

    /**
     *
     * @param i
     * @return
     */
    private int right(int i){
        return 2*i+2;
    }

    /**
     *
     * @param i
     * @return
     */
    private int parent(int i){
        return (i-1)/2;
    }

    /**
     * fix MinHeap property by comparing with parent
     * applicable for node value parent(i)> i
     * @param child
     */
    private void heapUp(int child){

        int parent;
        for(; child>0; child=parent){

            parent=parent(child);
            if(heapArr[parent].compareTo(heapArr[child])<=0){
                break;
            }
            T temp = heapArr[parent];
            heapArr[parent] = heapArr[child];
            heapArr[child] = temp;
        }
    }

    /**
     * fix MinHeap property by comparing with children
     * applicable for node value parent(i)<i
     * @param i
     */
    private void heapify(int i){

        int left = left(i);
        int right = right(i);
        int smallest = i;
        if(left<size && heapArr[left].compareTo(heapArr[smallest])<0){
            smallest = left;
        }

        if(right<size && heapArr[right].compareTo(heapArr[smallest])<0){
            smallest = right;
        }

        if(smallest!=i){
            T temp = heapArr[smallest];
            heapArr[smallest] = heapArr[i];
            heapArr[i] = temp;

            heapify(smallest);
        }
    }

    /**
     *
     * @param data
     */
    public void insert(T data){

        if(heapArr.length==size){
            throw new HeapFullException();
        }

        int i = size++;
        heapArr[i]=data;
        heapUp(i);
    }

    /**
     *
     * @return
     */
    public T extractMin(){
        if(size==0){
            throw new HeapEmptyException();
        }

        T root = heapArr[0];
        heapArr[0]=heapArr[--size];
        heapArr[size]=null;
        heapify(0);

        return root;
    }

    /**
     *
     * @param i
     */
    public T delete(int i){
        final T deletedNode = replace(i, heapArr[--size]);
        heapArr[size]=null;

        return deletedNode;
    }

    /**
     * Replaces a key with a new data.
     * This can be used for both decreaseKey() or increaseKey() operations.
     *
     * Depending upon the operations, it implies heapUp or heapify to fix broken heap property.
     *
     * @param i
     * @param data
     * @return
     */
    public T replace(int i, T data){

        if(i>=heapArr.length){
            throw new IllegalArgumentException("Index out of size: " + i);
        }

        final T deletedNode = heapArr[i];
        heapArr[i]=data;

        if(i>0 && heapArr[parent(i)].compareTo(heapArr[i])>0){
            heapUp(i);
        } else {
            heapify(i);
        }

        return deletedNode;
    }

    /**
     *
     */
    public void display(){
        for(int i=0; i<size; i++){
            System.out.print(heapArr[i] + ", ");
        }
        System.out.println();
    }

    /**
     *
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     *
     * @return
     */
    public boolean isFull(){
        return size==heapArr.length;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

}
