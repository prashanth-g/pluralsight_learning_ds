package com.prashanth.pluralsight.learning.ds.hash;

public class BasicHashTable<K, V> {

    private HashEntry[] data;
    private int capacity;

    public BasicHashTable(int tableSize) {
        this.capacity = capacity;
        this.data = new HashEntry[this.capacity];
    }

    private class HashEntry<K, V> {
        private K key;
        private V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
