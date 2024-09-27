public class HeapSort {
    // using indexing starting at 0 vs. book starting at 1 (this is why left is +1 and right is +2)
    public static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // if left child is larger than root
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) 
            largest = leftChild;
        
        // if right child is larger than largest thus far
        if (rightChild < heapSize && arr[rightChild] > arr[largest])
            largest = rightChild;
        
        // if largest is not the root node (must heapify)
        if (largest != rootIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            // recursively heapify the subtree that is not yet a heap
            heapify(arr, heapSize, largest);
        }
    }

    public static void buildHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = (heapSize / 2) - 1; i >= 0; i--)
            heapify(arr, heapSize, i);
    }

    public static void heapSort(int[] arr) {
        int heapSize = arr.length;
        buildHeap(arr);
        for (int i = heapSize - 1; i >= 0; i--) {
            // move current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}