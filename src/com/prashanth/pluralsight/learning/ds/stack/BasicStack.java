package com.prashanth.pluralsight.learning.ds.stack;

public class BasicStack<X> {

    private X [] data;
    private int statckPointer;

    public BasicStack() {
        data = (X[]) new Object[1000];
        statckPointer = 0;
    }

    public void pushItem(X newItem) {
        data[statckPointer++] = newItem;
    }

    public X popItem() {
        if(statckPointer == 0) {
            throw new IllegalStateException("No more items on the stack");
        }
        return data[--statckPointer];
    }

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

    public X access(X item) {
        while(statckPointer > 0) {
            X tempItem = popItem();
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
