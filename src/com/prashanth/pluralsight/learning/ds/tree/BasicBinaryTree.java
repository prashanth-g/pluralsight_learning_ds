package com.prashanth.pluralsight.learning.ds.tree;

public class BasicBinaryTree<T extends Comparable<T>> {

    private Node root;
    private int size;

    public BasicBinaryTree() {
        this.root = null;
    }

    public int size() {
        return size;
    }

    public void add(T item) {
       Node newNode = new Node(item);

       if(root == null) {
           this.root = newNode;
           this.size++;
       } else {
           insert(this.root, newNode);
       }
    }

    private void insert(Node parent, Node child) {
        if(child.getItem().compareTo(parent.getItem()) < 0) {
            if(parent.getLeft()== null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if(child.getItem().compareTo(parent.getItem()) > 0) {
            if(parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }

        // Assuming data in binary in unique so leaving == 0 condition
    }

    public boolean contains(T item) {
       if(getNode(item) != null) {
           return true;
       }
       return false;
    }

    private Node getNode(T item) {
        Node currentNode = this.root;
        while(currentNode != null) {
            int val = item.compareTo(currentNode.getItem());
            if(val == 0) {
                return currentNode;
            }
            else if(val < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }

    // Recursive
//    private boolean find(Node parent, T item) {
//        if(parent.getItem().equals(item)) {
//            return true;
//        } else {
//            if(item.compareTo(parent.getItem()) < 0) {
//                if(parent.getItem() == null) {
//                    parent = parent.getLeft();
//                    find(parent, item);
//                } else {
//                    return false;
//                }
//            } else if(item.compareTo(parent.getItem()) > 0) {
//                if(parent.getItem() == null) {
//                    parent = parent.getRight();
//                    find(parent, item);
//                } else {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }

    public boolean delete(T item) { // Unlinking and severing
        boolean deleted = false;

        if(this.root == null) {
            return false;
        }

        Node currentNode = getNode(item);

        if(currentNode != null) {
            if(currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                deleted = true;
            } else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            } else if(currentNode.getLeft() != null && currentNode.getRight() == null) {
                unlink(currentNode, currentNode.getLeft());
                deleted = true;
            } else {

                // Go to the left of the current node (which has to be deleted)
                Node child = currentNode.getLeft();
                // Find the right most node of this child - if any
                while (child.getLeft() != null && child.getRight() != null) {
                    child = child.getRight();
                }

                // Swap it with the current node

                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());

//                child.setRight(currentNode.getRight());
//                child.getParent().setRight(null);

                // Unlink or delete the current node
                unlink(currentNode, child);
                deleted = true;
            }
        }

        if(deleted) { size-- ;}

        return deleted;
    }

    private void unlink(Node currentNode, Node newNode) {
        if(currentNode == this.root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if(currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else if(currentNode.getParent().getLeft() == currentNode) {
            currentNode.getParent().setLeft(newNode);
        }
    }

    private class Node {

        private Node left;
        private Node right;
        private Node parent;
        private T item;

        public Node(T item) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }
}
