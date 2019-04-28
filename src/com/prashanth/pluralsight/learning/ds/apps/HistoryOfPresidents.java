package com.prashanth.pluralsight.learning.ds.apps;

import com.prashanth.pluralsight.learning.ds.tree.BasicBinaryTree;

public class HistoryOfPresidents {

    BasicBinaryTree<President> presidentsBinaryTree = new BasicBinaryTree<>();

    public static void main(String[] args) {
        HistoryOfPresidents historyOfPresidents = new HistoryOfPresidents();
        historyOfPresidents.addPresidents();
        historyOfPresidents.searchPresidents();
        historyOfPresidents.removePresidents();
    }

    // Add Presidents
    public void addPresidents() {
        presidentsBinaryTree.add(new President("Lincoln"));
        presidentsBinaryTree.add(new President("Jefferson"));
        presidentsBinaryTree.add(new President("Washington"));
        presidentsBinaryTree.add(new President("Jackson"));
        presidentsBinaryTree.add(new President("Kennedy"));
        presidentsBinaryTree.add(new President("Madison"));
        presidentsBinaryTree.add(new President("Adams"));
        presidentsBinaryTree.add(new President("Roosevelt"));
        presidentsBinaryTree.add(new President("Buchanan"));
        System.out.println("Added 9 Presidents");
    }

    // Search Presidents
    public void searchPresidents() {
        boolean isPresent = presidentsBinaryTree.contains(new President("Adams"));
        System.out.println(isPresent);
    }
    // Clean Presidents
    public void removePresidents() {
        presidentsBinaryTree.delete(new President("Jefferson"));
        System.out.println(presidentsBinaryTree.size() + " Presidents remaining");
    }

    private class President implements Comparable<President> {

        private String name;

        public President(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(President other) {
            return this.name.compareTo(other.name);
        }
    }

}
