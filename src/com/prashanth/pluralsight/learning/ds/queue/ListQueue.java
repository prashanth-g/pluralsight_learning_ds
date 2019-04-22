package com.prashanth.pluralsight.learning.ds.queue;

import java.util.ArrayList;

public class ListQueue<T> implements Queue<T> {

    private ArrayList<T> data;
    private static final int DEFAULT_CAPACITY = 100;

    public ListQueue() {
        data = new ArrayList<>(DEFAULT_CAPACITY);
    }

    @Override
    public void enQueue(T element) {
        // If list is full throw Ex
        if(this.isFull()) {
            throw new IllegalStateException("Queue is full!");
        } else {
            data.add(element);
        }

    }

    @Override
    public T deQueue() {
        if(this.isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        T element = data.get(0);
        data.remove(0);
        return element;
    }

    @Override
    public boolean contains(T element) {
        return data.contains(element);
    }

    @Override
    public T access(int position) {
        return data.get(position); // Add empty check
    }

    @Override
    public int size() {
        return data.size();
    }

    private boolean isFull() {
        return (size() == DEFAULT_CAPACITY);
    }

    private boolean isEmpty() {
        return (data.size() == 0);
    }
}
