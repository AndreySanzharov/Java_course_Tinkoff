package edu.hw3;

import java.util.Comparator;
import java.util.TreeMap;

public class Task7 {
    private Task7() {
    }

    public class NullHandlingTreeMap<K, V> extends TreeMap<K, V> {
        public NullHandlingTreeMap(Comparator<? super K> comparator) {
            super(comparator);
        }

        @Override
        public V put(K key, V value) {
            if (key == null) {
                throw new NullPointerException("Null keys are not allowed");
            }
            return super.put(key, value);
        }
    }
}
