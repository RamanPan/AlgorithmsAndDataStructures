import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class TimSort {
    public static int MIN_RUN = 32;
    public static boolean howSort = false;

    public static void calculateMinRun(int size) {
        int value = 0;
        while (size >= 64) {
            value |= size & 1;
            size >>= 1;
        }
        MIN_RUN = size + value;
    }

    static void insertionSort(int[] arr, int left, int right) {
        int temp;
        for (int i = left + 1; i < right + 1; i++) {
            int j = i;
            if (howSort) {
                while (j > left && arr[j] > arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
            } else {
                while (j > left && arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int len1 = middle - left + 1, len2 = right - middle;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, middle + 1, rightArr, 0, len2);
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }
        while (i < len1) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        while (j < len2) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }

    public static void timSort(int[] arr) {
        calculateMinRun(arr.length);
        for (int start = 0; start < arr.length; start += MIN_RUN) {
            int end = Math.min(start + MIN_RUN - 1, arr.length - 1);
            insertionSort(arr, start, end);
        }
        int size = MIN_RUN, doubleSize;
        while (size < arr.length) {
            doubleSize = 2 * size;
            for (int left = 0; left < arr.length; left += doubleSize) {
                int middle = Math.min(arr.length - 1, left + size - 1);
                int right = Math.min(left + doubleSize - 1, arr.length - 1);
                if (middle < right) merge(arr, left, middle, right);
            }
            size = doubleSize;
        }
    }

    public static void main(String[] args) {
        int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        System.out.println(Arrays.toString(randomIntsArray));
        long startTime = System.nanoTime();
        timSort(randomIntsArray);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(randomIntsArray));
        System.out.println((double) (endTime - startTime) / 1000000000 + " second");
    }
}