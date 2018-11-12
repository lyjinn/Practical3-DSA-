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
    private final static int frontIndex = 0;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public ArrayQueue(int initialCapacity) {
        queue = (T[]) new Object[initialCapacity];
        backIndex = -1;
    } // end constructor

    @Override
    public void enqueue(T newEntry) {
        if (isArrayFull()) // isArrayFull and
        {
            doubleArray();   // doubleArray are private
        }
        backIndex++;
        queue[backIndex] = newEntry;
    } // end enqueue

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = queue[frontIndex];
        }

        return front;
    } // end getFront

    @Override
    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = queue[frontIndex];

            // shift remaining queue items forward one position
            for (int i = frontIndex; i < backIndex; ++i) {
                queue[i] = queue[i + 1];
            }

            backIndex--;
        } // end if

        return front;
    } // end dequeue

    @Override
    public boolean isEmpty() {
        return frontIndex > backIndex;
    } // end isEmpty

    @Override
    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion
            for (int index = frontIndex; index <= backIndex; index++) {
                queue[index] = null;
            } // end for

            backIndex = -1;
        } // end if
    } // end clear

    private boolean isArrayFull() {
        return backIndex == queue.length - 1;
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
