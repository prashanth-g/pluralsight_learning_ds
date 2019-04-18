package com.prashanth.pluralsight.learning.ds.stack;

public class BasicStack<X> {

    private X [] data;
    private int statckPointer;

    public BasicStack() {
        data = (X[]) new Object[1000];
        statckPointer = 0;
    }

    // O(1)
    public void push(X newItem) {
        data[statckPointer++] = newItem;
    }

    // O(1)
    public X pop() {
        if(statckPointer == 0) {
            throw new IllegalStateException("Could not find any item to pop");
        }
        return data[--statckPointer];
    }

    // O(n)
    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < statckPointer; i++) {
            if(data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    // O(n)
    public X access(X item) {
        while(statckPointer > 0) {
            X tempItem = pop();
            if(item.equals(tempItem)) {
                return tempItem;
            }
        }

        throw new IllegalArgumentException("Could not find the item in the stack :" + item);
    }

    public int size() {
        return statckPointer;
    }
}
