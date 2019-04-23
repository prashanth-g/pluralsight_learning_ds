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
