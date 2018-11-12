/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a;

/**
 *
 * @author Tarc
 */
public class CircularArrayQueue<T> implements QueueInterface<T> {

    private T[] array;
    private int firstIndex, lastIndex;
    private static final int DEFAULT_SIZE = 5;

    public CircularArrayQueue() {
        this(DEFAULT_SIZE);
    } // end default constructor

    public CircularArrayQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        firstIndex = 0;
        lastIndex = -1;
    } // end constructor

    @Override
    public void enqueue(T newEntry) {
        lastIndex = (lastIndex + 1) % array.length;
        if (isArrayFull()) // isArrayFull and
        {
            doubleArray();   // doubleArray are private
        }
        array[lastIndex] = newEntry;
    } // end enqueue

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = array[firstIndex];
        }

        return front;
    } // end getFront

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = array[firstIndex];

            firstIndex = (firstIndex + 1) % array.length;
        } // end if

        return front;
    } // end dequeue

    @Override
    public boolean isEmpty() {
        return (lastIndex+1)%array.length + 1 == (firstIndex+1)%array.length;
    } // end isEmpty

    @Override
    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion
            for (int index = firstIndex; index <= lastIndex; index++) {
                array[index] = null;
            } // end for

            lastIndex = -1;
        } // end if
    } // end clear

    private boolean isArrayFull() {
        return (lastIndex+2)%array.length + 1 == (firstIndex+2)%array.length;
    }

    private void doubleArray() {
        T[] oldArray = array;
        int size = oldArray.length;

        array = (T[]) new Object[2 * size];

        for (int i = 0; i < (size - 1); i++) {
            array[i] = oldArray[firstIndex];
            firstIndex = (firstIndex + 1) % oldArray.length;
        }

        firstIndex = 0;
        lastIndex = size - 1;
    }
}
