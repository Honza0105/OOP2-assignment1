package domain;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomOrderIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;
    private ReorderingPriorityQueue<T> queue;
    private T current;
    private Comparator<T> comparator;

    public CustomOrderIterator(ReorderingPriorityQueue<T> queue) {
        this.queue = queue;
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
        current = iterator.next();
        return current;
    }



    @Override
    public void remove() {
        iterator.remove();
    }
}

