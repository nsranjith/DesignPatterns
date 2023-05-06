package collections;

public class HashMap<K, V> {
    private Entry<K, V>[] entries;
    private int size;

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        entries = new Entry[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (entries[index] == null) {// if position not occupied
            entries[index] = new Entry<>(key, value);
            size++;
        } else {
            Entry<K, V> current = entries[index];

            while (current != null) {
                if (current.key.equals(key)) {// if value already present
                    current.value = value;
                    return;
                }

                current = current.next; // move next
            }

            Entry<K, V> newEntry = new Entry<>(key, value);
            newEntry.next = entries[index];
            entries[index] = newEntry;
            size++;
        }

        if (size > entries.length * DEFAULT_LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> current = entries[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> current = entries[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    entries[index] = current.next;
                } else {
                    prev.next = current.next;
                }

                size--;
                return;
            }

            prev = current;
            current = current.next;
        }
    }

    private int hash(K key) {
        return key.hashCode() % entries.length;
    }

    private void resize() {
        Entry<K, V>[] newEntries = new Entry[entries.length * 2];

        for (Entry<K, V> entry : entries) {
            while (entry != null) {
                int index = hash(entry.key);

                if (newEntries[index] == null) {
                    newEntries[index] = new Entry<>(entry.key, entry.value);
                } else {
                    Entry<K, V> current = newEntries[index];

                    while (current.next != null) {
                        current = current.next;
                    }

                    current.next = new Entry<>(entry.key, entry.value);
                }

                entry = entry.next;
            }
        }

        entries = newEntries;
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
