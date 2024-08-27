public class InsertionSort {
    // numbers to be sorted are called the keys
    public static int[] insertionSort(int[] arr, int valuesToSort) {
        for (int i = 1; i < valuesToSort; i++) {
            int key = arr[i];

            // insert arr[i] into the sorted subarray A[1 : i-1]
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arrToSort = {5, 3, 22, 7, 1, 9, 12, 6};
        insertionSort(arrToSort, arrToSort.length);
        System.out.print("Your sorted array is: " + arrToSort[0]);
        for (int i = 1; i < arrToSort.length; i++) {
            System.out.print(", " + arrToSort[i]);
        }
    }
}