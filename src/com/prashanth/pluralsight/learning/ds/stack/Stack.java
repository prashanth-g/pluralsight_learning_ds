package com.prashanth.pluralsight.learning.ds.stack;

public interface Stack<T> {

    public void push(T element);

    public T pop();

    public boolean contains(T element);

    public T access(T element);

    public int size();

}
