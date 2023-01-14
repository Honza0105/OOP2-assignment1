package domain;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class CustomOrderIterator<T> implements Iterator<T> {
    private ReorderingPriorityQueue<T> priorityQueue;
    private Comparator<T> comparator;

    public CustomOrderIterator(ReorderingPriorityQueue<T> priorityQueue, Comparator<T> comparator) {
        this.priorityQueue = priorityQueue;
        this.comparator = comparator;
    }

    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        return priorityQueue.poll();
    }
}
