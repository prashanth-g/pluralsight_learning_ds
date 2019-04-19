package com.prashanth.pluralsight.learning.ds.stack;

public class BasicStack<T> implements Stack<T>{

    private T [] data;
    private int statckPointer;

    public BasicStack() {
        data = (T []) new Object[1000];
        statckPointer = 0;
    }

    // O(1)
    public void push(T newItem) {
        data[statckPointer++] = newItem;
    }

    // O(1)
    public T pop() {
        if(statckPointer == 0) {
            throw new IllegalStateException("Could not find any item to pop");
        }
        return data[--statckPointer];
    }

    // O(n)
    public boolean contains(T item) {
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
    public T access(T item) {
        while(statckPointer > 0) {
            T tempItem = pop();
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
