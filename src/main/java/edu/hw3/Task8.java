package edu.hw3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Task8 {
    public static class BackwardIterator<T> implements Iterator<T> {
        private final List<T> elements;
        private int currentIndex;

        public BackwardIterator(Collection<T> collection) {
            this.elements = new java.util.ArrayList<>(collection);
            this.currentIndex = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextElement = elements.get(currentIndex);
                currentIndex--;
                return nextElement;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
