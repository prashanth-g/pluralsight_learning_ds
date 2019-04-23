package com.prashanth.pluralsight.learning.ds.list;

public class BasicLinkedList<T> {

    private Node first;
    private Node last;

    public BasicLinkedList() {
        first = null;
        last = null;
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
