/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a;

/**
 *
 * @author Jinn
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private int firstIndex, lastIndex;
    private static final int DEFAULT_SIZE = 5;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    } // end default constructor

    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
        firstIndex = 0;
        lastIndex = -1;
    } // end constructor

    @Override
    public void enqueue(T newEntry) {
        lastIndex++;
        if (isArrayFull()) // isArrayFull and
        {
            doubleArray();   // doubleArray are private
        }
        queue[lastIndex] = newEntry;
    } // end enqueue

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = queue[firstIndex];
        }

        return front;
    } // end getFront

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = queue[firstIndex];

            firstIndex++;
        } // end if

        return front;
    } // end dequeue

    @Override
    public boolean isEmpty() {
        return lastIndex + 1 == firstIndex;
    } // end isEmpty

    @Override
    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion
            for (int index = firstIndex; index <= lastIndex; index++) {
                queue[index] = null;
            } // end for

            lastIndex = -1;
        } // end if
    } // end clear

    private boolean isArrayFull() {
        return lastIndex == queue.length;
    } // end isArrayFull

    private void doubleArray() {
        T[] oldQueue = queue;
        int oldSize = oldQueue.length;

        queue = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            queue[index] = oldQueue[index];
        } // end for
    } // end doubleArray
}
