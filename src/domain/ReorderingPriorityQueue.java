package domain;

import java.util.*;

public class ReorderingPriorityQueue<T> implements Queue<T>{
    PriorityQueue<T> priorityQueue;
    private Comparator<T> comparator;

    public ReorderingPriorityQueue() {
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public String toString() {
        reorder();
        return "ReorderingPriorityQueue{" +
                "priorityQueue=" + priorityQueue +
                ", comparator=" + comparator +
                '}';
    }

    public ReorderingPriorityQueue(Comparator<T> customComparator) {
        this.comparator = customComparator;
        this.priorityQueue = new PriorityQueue<>(customComparator);
    }

    public void setComparator(Comparator<T> comparator){
       this.comparator = comparator;
        PriorityQueue<T> newQueue = new PriorityQueue<>(comparator);
        newQueue.addAll(priorityQueue);
        priorityQueue = newQueue;
    }
    @Override
    public int size() {
        return priorityQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return priorityQueue.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        reorder();
        return new CustomOrderIterator<T>(this.priorityQueue.iterator());
    }

    @Override
    public Object[] toArray() {
        return priorityQueue.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return priorityQueue.toArray(a);
    }


    @Override
    public boolean add(T o) {
        reorder();
        return priorityQueue.add(o);
    }

    @Override
    public boolean remove(Object o) {
        return priorityQueue.remove(o);
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {
        return priorityQueue.addAll(c);
    }

    @Override
    public void clear() {
        priorityQueue.clear();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return priorityQueue.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return priorityQueue.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return priorityQueue.containsAll(c);
    }

    @Override
    public boolean offer(T o) {
        reorder();
        return priorityQueue.offer(o);
    }

    @Override
    public T remove() {
        reorder();
        return priorityQueue.remove();
    }

    @Override
    public T poll() {
        return priorityQueue.poll();
    }

    @Override
    public T element() {
        return priorityQueue.element();
    }

    @Override
    public T peek() {
        return priorityQueue.peek();
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public void reorder() {
        // Create a temporary list to hold the elements
        List<T> tempList = new ArrayList<>();
        // Keep polling elements from the queue until it's empty
        while (!isEmpty()) {
            tempList.add(poll());
        }
        // Sort the elements in the temporary list
        tempList.sort(comparator);
        // Add the elements back to the queue
        for (T element : tempList) {
            add(element);
        }
    }

}
