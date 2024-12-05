package io.github.scpiota.coscfinal;

import java.util.Random;

public class HeapDemo {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>((a, b) -> a.compareTo(b));
        var rand = new Random();

        for(int i = 0; i < 20; i++) {
            heap.add(rand.nextInt(100));
        }

        for(int i = 0; i < 20; i++) {
            System.out.println(heap.remove());
        }
    }
}
