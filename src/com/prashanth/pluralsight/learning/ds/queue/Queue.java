package com.prashanth.pluralsight.learning.ds.queue;

public interface Queue<T> {

    public void enQueue(T element);

    public T deQueue();

    public boolean contains(T element);

    public T access(int position);

    public int size();
}
