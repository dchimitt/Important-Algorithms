public class MergeSort {
    // numbers to be sorted are called the keys
    public static int[] mergeSort(int[] arr, int valuesToSort) {
        return arr;
    }

    public static void main(String[] args) {
        int[] arrToSort = {5, 3, 22, 7, 1, 9, 12, 6};
        mergeSort(arrToSort, arrToSort.length);
        System.out.print("Your sorted array is: " + arrToSort[0]);
        for (int i = 1; i < arrToSort.length; i++) {
            System.out.print(", " + arrToSort[i]);
        }
    }
}