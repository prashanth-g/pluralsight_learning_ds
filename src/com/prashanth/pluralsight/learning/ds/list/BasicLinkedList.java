package com.prashanth.pluralsight.learning.ds.list;

public class BasicLinkedList<T> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(T item) {
        if(first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode); // Set current last node's next node to new node
            last = newLastNode;
        }
        nodeCount++;
    }

    public void insert(T item, int position) {
        if(size() < position) {
            throw new IllegalArgumentException("Position not found");
        }

        Node currentNode = first;

        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();

        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);

        nodeCount++;
    }

    public T removeAt(int position) {
        if(first == null) {
            throw new IllegalStateException("LinkedList is empty, there is no item to remove");
        }

        Node currentNode = first;
        Node prevNode = first;

        for (int i = 1; i < position && currentNode != null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // Get next to next of current  - S
        T nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    public T remove() {
        if(first == null) {
            throw new IllegalArgumentException("LinkedList is empty!");
        } else {
            // Get node
             T nodeItem = first.getNodeItem();
            // Change previous node's next node
            first = first.getNextNode();
            nodeCount--;
            return nodeItem;
        }
    }

    public T get(int position) {
        if(size() < position) {
            throw new IllegalArgumentException("Position not found");
        }

        Node currentNode = first;

        for (int i = 1; i < position && currentNode != null; i++) {
            if(i == position) {
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    // 4, 3, 6
    // 0, 1, 2
    public int findItem(T item) {
        if (first == null) {
            throw new IllegalArgumentException("LinkedList is empty");
        }

        Node currentNode = first;


        for (int i = 1; i < size() && currentNode != null; i++) {
            if(currentNode.getNodeItem() == item) {
                return i;
            }
            currentNode = currentNode.getNextNode();
        }

        return -1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node currentNode = first;

        while(currentNode != null) {
            stringBuffer.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();

            // If next is not null
            if(currentNode != null) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    private class Node {

        private T nodeItem;
        private Node nextNode;

        // Create a new node
        public Node(T nodeItem) {
            this.nodeItem = nodeItem;
            this.nextNode = null;
        }

        public T getNodeItem() {
            return nodeItem;
        }

        // Not usable
        public void setNodeItem(T nodeItem) {
            this.nodeItem = nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
