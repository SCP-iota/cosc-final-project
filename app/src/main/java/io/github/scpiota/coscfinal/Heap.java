package io.github.scpiota.coscfinal;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private ArrayList<T> items;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.items = new ArrayList<>();
        this.comparator = comparator;
    }

    private void siftDown(int i) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        int min = i;

        if(leftIndex < items.size() && comparator.compare(items.get(leftIndex), items.get(min)) > 0) {
            min = leftIndex;
        }

        if(rightIndex < items.size() && comparator.compare(items.get(rightIndex), items.get(min)) > 0) {
            min = rightIndex;
        }

        if(min != i) {
            T temp = items.get(i);
            items.set(i, items.get(min));
            items.set(min, temp);
            siftDown(min);
        }
    }

    private void siftUp(int i) {
        int parentIndex = (i - 1) / 2;

        if(i > 0 && comparator.compare(items.get(i), items.get(parentIndex)) > 0) {
            T temp = items.get(i);
            items.set(i, items.get(parentIndex));
            items.set(parentIndex, temp);
            siftUp(parentIndex);
        }
    }

    public void add(T item) {
        items.add(item);
        siftUp(items.size() - 1);
    }

    public T remove() {
        if(items.isEmpty()) {
            return null;
        }

        T removed = items.removeFirst();

        if(!items.isEmpty()) {
            items.addFirst(items.removeLast());
            siftDown(0);
        }

        return removed;
    }
}
