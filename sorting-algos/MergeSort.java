public class MergeSort {
    // subarray arr[p:r], where p = startingIndex, r = endingIndex, q = midIndex
    public static void mergeSort(int[] startingArr, int startingIndex, int endingIndex) {
        // zero or one element in array
        if (startingIndex >= endingIndex)
            return;
        int midIndex = (startingIndex + endingIndex) / 2;
        mergeSort(startingArr, startingIndex, midIndex);
        mergeSort(startingArr, midIndex + 1, endingIndex);

        // merge A[p:q] and A[q + 1 : r] into A[p:r]
        merge(startingArr, startingIndex, midIndex, endingIndex);        
    }

    public static int[] merge(int[] startingArr, int startingIndex, int midIndex, int endingIndex) {
        // calculate length of the two halves and then initialize the two halves
        int leftHalfLength = midIndex - startingIndex + 1;
        int rightHalfLength = endingIndex - midIndex;
        int[] arrLeftHalf = new int[leftHalfLength];
        int[] arrRightHalf = new int[rightHalfLength];

        // copying startingArr values into their respective halves
        for (int i = 0; i < leftHalfLength; i++)
            arrLeftHalf[i] = startingArr[startingIndex + i];
        for (int j = 0; j < rightHalfLength; j++)
            arrRightHalf[j] = startingArr[midIndex + j + 1];
        
        int i = 0; // indexes smallest remaining element in left half
        int j = 0; // indexes smallest remaining element in right half
        int k = startingIndex; // indexes location in startingArr to fill

        // if each half contains an unmerged element, copy the smallest unmerged element back into A[p:r]
        while (i < leftHalfLength && j < rightHalfLength) {
            if (arrLeftHalf[i] <= arrRightHalf[j]) {
                startingArr[k] = arrLeftHalf[i];
                i++;
            }
            else {
                startingArr[k] = arrRightHalf[j];
                j++;
            }
            k++;
        }

        // after going through one of left half and right half entirely, copy the remainder of the other to the end of A[p:r]
        while (i < leftHalfLength) {
            startingArr[k] = arrLeftHalf[i];
            i++;
            k++;
        }
        while (j < rightHalfLength) {
            startingArr[k] = arrRightHalf[j];
            j++;
            k++;
        }

        return startingArr;
    }

    public static void main(String[] args) {
        int[] arrToSort = {5, 3, 22, 7, 1, 9, 12, 6};
        mergeSort(arrToSort, 0, arrToSort.length - 1);
        System.out.print("Your sorted array is: " + arrToSort[0]);
        for (int i = 1; i < arrToSort.length; i++) {
            System.out.print(", " + arrToSort[i]);
        }
    }
}