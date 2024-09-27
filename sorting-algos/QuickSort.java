public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partition the array
            int pivotIndex = partition(arr, low, high);

            // recursively sort eles before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // using last element as the pivot position
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // pointer for the smallest element

        for (int j = low; j < high; j++) {
            // if current ele is smaller than or equal to the pivot
            if (arr[j] <= pivot) {
                i++; // increment index of smaller element
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i + 1] and pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}