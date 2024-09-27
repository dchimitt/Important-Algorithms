public class CountingSort {
    public static void countingSort(int[] arr, int maxVal) {
        // initialize the count array with size maxVal + 1
        int[] count = new int[maxVal + 1];
        int[] output = new int[arr.length];

        // count the occurrences of each element in the input array
        for (int num : arr) {
            count[num]++;
        }

        // update the count array to store the cumulative sum
        for (int i = 1; i <= maxVal; i++) {
            count[i] += count[i - 1];
        }

        // build the output array using the count array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // copy the output array back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
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

        // call counting sort with the maximum value in the array
        countingSort(arr, 13);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
