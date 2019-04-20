package com.prashanth.pluralsight.learning.ds.queue;

public class BasicQueue<T> implements Queue<T> {

    private T[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(500);
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (T[]) new Object[size];
    }

    @Override
    public void enQueue(T element) {
        if((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full!");
        }
        else if(size() == 0) {
            front++;
            end++;
            data[end] = element;
        } else {
            end++;
            data[end] = element;
        }
    }

    @Override
    public T deQueue() {
        T item = null;

        if(size() == 0) {
            throw new IllegalStateException("Queue is empty!");
        } else if(front == end) {
            item = data[front]; // clear the dequeued spot
            data[front] = null;
            front--;
            end--;
        } else {
            item = data[front];
            data[front] = null; // clear the dequeued spot
            front++;
        }

        return item;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T access(T element) {
        return null;
    }

    @Override
    public int size() {
        if(front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }
}



