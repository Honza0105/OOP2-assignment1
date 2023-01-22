package domain;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomOrderIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public CustomOrderIterator(ReorderingPriorityQueue<T> queue) {
        this.iterator = queue.priorityQueue.iterator();
    }

    public CustomOrderIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }


    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterator.next();
    }



    @Override
    public void remove() {
        iterator.remove();
    }
}

