package case_study_3;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryHeapVersion2 {
    private ArrayList<Integer> heap;

    private BinaryHeapVersion2(int size) {
        heap = new ArrayList<>(size);
    }

    private void insert(int value) {
        heap.add(value);

        int index = heap.size() - 1;
        int parent = (index - 1) / 2;

        while (index > 0 && heap.get(parent) < heap.get(index)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);

            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private int poll() {
        if (heap.size() == 0) {
            throw new NoSuchElementException();
        }

        int max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }

    private void heapify(int i) {
        int left;
        int right;
        int largest;

        for (; ; ) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            largest = i;

            if (left < heap.size()) {
                if (heap.get(largest) < heap.get(left)) largest = left;
            }

            if (right < heap.size()) {
                if ((heap.get(largest)) < heap.get(right)) largest = right;
            }

            if (largest == i) break;

            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            i = largest;
        }
    }

    public static void main(String[] args) {
        BinaryHeapVersion2 bheap = new BinaryHeapVersion2(10);

        bheap.insert(20);
        bheap.insert(15);
        bheap.insert(11);
        bheap.insert(9);
        bheap.insert(7);
        bheap.insert(6);
        bheap.insert(1);
        bheap.insert(3);
        bheap.insert(5);
        bheap.insert(8);

        System.out.print("before poll: ");
        bheap.heap.forEach(value -> System.out.print(value + " "));

        int max = bheap.poll();

        System.out.println("\npoll: " + max);

        System.out.print("after poll: ");
        bheap.heap.forEach(value -> System.out.print(value + " "));
    }
}