package case_study_3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private int[] heap;

    private BinaryHeap(int size) {
        this.heap = new int[size];
    }

    private void insert(int value) {
        grow();
        int newLength = heap.length;
        heap[newLength - 1] = value;

        int index = heap.length - 1;
        int parent = (index - 1) / 2;

        while (index > 0 && heap[parent] < heap[index]) {
            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private int poll() {
        if (heap.length == 0) {
            throw new NoSuchElementException();
        }

        int max = heap[0];
        heap[0] = heap[heap.length - 1];
        heap = Arrays.copyOf(heap, heap.length - 1);
        heapify(0);
        return max;
    }

    private void grow() {
        int oldLength = heap.length;
        int newLength = oldLength + 1;

        heap = Arrays.copyOf(heap, newLength);
    }

    private void heapify(int i) {
        int left;
        int right;
        int largest;

        for (; ; ) {
            left = 2 * i + 1;
            right = 2 * i + 2;
            largest = i;

            if (left < heap.length) {
                if (heap[largest] < heap[left]) largest = left;
            }

            if (right < heap.length) {
                if ((heap[largest]) < heap[right]) largest = right;
            }

            if (largest == i) break;

            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            i = largest;
        }
    }

    public static void main(String[] args) {
        BinaryHeap newHeap = new BinaryHeap(10);

        newHeap.heap = new int[]{20, 11, 15, 6, 9, 7, 8, 1, 3, 5};

        System.out.println("initial heap: " + Arrays.toString(newHeap.heap));

        newHeap.insert(17);

        System.out.println("after insert: " + Arrays.toString(newHeap.heap));

        int max = newHeap.poll();

        System.out.println("result of poll is: " + max);

        System.out.println("after poll: " + Arrays.toString(newHeap.heap));
    }
}
