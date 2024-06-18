package HashMaps;

import java.util.*;

public class MyHashmaps<K,V> {
    // Return the all of the keys only in list of strings
    public String[] keySet() {
        ArrayList<String> keys = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                keys.add(entry.getKey().toString());
                entry = entry.next;
            }
        }
        return keys.toArray(new String[0]);
    }
    // Return all of the values only in list of strings
    public String[] values() {
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                values.add(entry.getValue().toString());
                entry = entry.next;
            }
        }
        return values.toArray(new String[0]);
    }
    // return the all of the values only
    public Set<Entry<K,V>> entrySet() {
        Set<Entry<K,V>> entries = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            Entry<K,V> entry = table[i];
            while (entry != null) {
                entries.add(entry);
                entry = entry.next;
            }
        }
        return entries;
    }
    // Display the score and name
    public String[] displayScore(int[] sortedScores){
        List<String> sortedNames = new ArrayList<>();
        for (int score : sortedScores) {
            for (Entry<K, V> entry : entrySet()) {
                if (entry.getValue().equals(score)) {
                    sortedNames.add(entry.getKey().toString());
                    break; // Found the name, move to the next score
                }
            }
        }
        String[] displaytheScores = new String[sortedNames.size()];
        for (int i = 0; i < sortedNames.size(); i++) {
            displaytheScores[i] = sortedNames.get(i) + ": " + sortedScores[i];
        }
        return displaytheScores;
    }


    public class Entry<K,V>{
        private V value;
        private K key;
        private Entry<K,V> next;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
        public K getKey() {
            return key;
        }


        @Override
        public String toString() {
            Entry<K,V> temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.key + " -> " + temp.value + ",");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
    //field or HashMaps.MyHashmaps
    private final int SIZE = 10000; // creates the size for array

    private Entry<K,V> table[]; // field

    public MyHashmaps(){
        table = new Entry[SIZE];
    }
    // Hashing algorithm
    private int getHash(K key) {
        int hash = Math.abs(key.hashCode()) % SIZE;
        return hash;
    }
    // Put the key
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }

        int hash = getHash(key);
        Entry<K, V> e = table[hash];
        Entry<K, V> prev = null;

        while (e != null) {
            if (e.getKey().equals(key)) {
                // Key already exists, update its value
                e.setValue(value);
                return;
            }
            prev = e;
            e = e.next;
        }

        // Key doesn't exist, add a new entry
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (prev == null) {
            // No collision, add at the head of the linked list
            table[hash] = newEntry;
        } else {
            // Collision occurred, add at the end of the linked list
            prev.next = newEntry;
        }
    }

    // Get the value from hashmap by using the key
    public V get(K key){
        int hash = getHash(key);
        Entry<K, V> e = table[hash];

        if (e == null){
            return null;
        }
        while (e != null){
            if(e.getKey().equals(key)){
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }
    // Remove key and value
    public Entry<K, V> remove(K key) {
        int hash = getHash(key);
        Entry<K, V> e = table[hash];

        if (e == null) {
            return null;
        }

        if (e.getKey().equals(key)) {
            table[hash] = e.next;
            e.next = null;
            return e;
        }

        Entry<K, V> prev = e;
        e = e.next;

        while (e != null) {
            if (e.getKey() == key) {
                prev.next = e.next;
                e.next = null;
                return e;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                sb.append(i + " " + table[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }

        return sb.toString();
    }

}


