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
public class ArrayStack<T> implements StackInterface<T> {

    private T[] stack;    // array of stack entries
    private int topIndex; // index of top entry
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    } // end default constructor

    public ArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        topIndex = -1;
    } // end constructor

    @Override
    public void push(T newEntry) {
        topIndex++;

        if (topIndex >= stack.length) // if array is full,
        {
            doubleArray();              // expand array
        }
        stack[topIndex] = newEntry;
    } // end push

    @Override
    public T peek() {
        T top = null;

        if (!isEmpty()) {
            top = stack[topIndex];
        }

        return top;
    } // end peek

    @Override
    public T pop() {
        T top = null;

        if (!isEmpty()) {
            top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
        } // end if

        return top;
    } // end pop

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    } // end isEmpty

    @Override
    public void clear() {

    } // end clear

    /**
     * Task: Doubles the size of the array of stack entries. Refer to Segment
     * 5.18
     */
    private void doubleArray() {
        T[] oldStack = stack;                // get reference to array of stack entries
        int oldSize = oldStack.length;       // get max size of original array

        stack = (T[]) new Object[2 * oldSize]; // double size of array

        // copy entries from old array to new, bigger array
        System.arraycopy(oldStack, 0, stack, 0, oldSize);
    } // end doubleArray
}
