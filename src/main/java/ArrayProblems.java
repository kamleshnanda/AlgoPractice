import java.util.HashMap;

public class ArrayProblems {
    public static void main(String[] args) {
        arrayProblem1();
        arrayProblem2();
        arrayProblem3();
        arrayProblem4();
        arrayProblem5();
        arrayProblem6();
    }

    /**
     * Find the element that appears once in a sorted array where all other elements
     * appear twice one after another. Find that element in 0(logn) complexity.
     * Input: arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8} Output: 4 Response:
     */
    private static void arrayProblem1() {
        System.out.println(
                "Find the element that appears once in a sorted array where all other elements appear twice one after another.");
        System.out.println("==================================================================");
        int[] arr = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };
        int result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);

        arr = new int[] { 1, 1, 2, 2, 3 };
        result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);

        arr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 7, 7 };
        result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);

        arr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 7 };
        result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);

        arr = new int[] { 1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 7 };
        result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);

        arr = new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 7, 8, 8, 9, 10, 10 };
        result = findElementIndexThatOccursOnce(arr);
        printArray("Input Array", arr);
        System.out.printf("Unique element at index: %d with value %d\n", result, arr[result]);
    }

    private static int findElementIndexThatOccursOnce(int[] arr) {
        int result = -1;
        if (arr == null) {
            System.err.println("findElementIndexThatOccursOnce Error: Input array null");
            return result;
        } else if (arr.length % 2 == 0) {
            System.err.println("findElementIndexThatOccursOnce Error: Input array cannot have even number of elements");
            return result;
        } else if (arr.length == 1) {
            result = 0; 
            return result;
        }
        int low = 0, high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (low == high) { // mid is not equal to either side)
                result = low;
                break;
            }
            int midEven = mid % 2;
            if (midEven == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            } else if (midEven == 1) {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }

    /**
     * A magic index in an array A[0…n-1] is defined to be an index such that A[i] =
     * i. Given a sorted array of distinct integers, write a method to find a magic
     * index if one exists, in an array A. FOLLOW UP: What if the values are not
     * distinct? - Havnt done
     */
    private static void arrayProblem2() {
        System.out.println("Given a sorted array of distinct integers, Find a magic index such that A[i] == i");
        System.out.println("==================================================================");
        int[] arr1 = { -2, -1, 1, 2, 4, 8, 10 };
        int magicIndex = findMagicIndex(arr1);
        printArray("Input Array", arr1);
        System.out.printf("Magic index is %d, value at %d is %d\n", magicIndex, magicIndex, arr1[magicIndex]);
        int[] arr2 = { -2, 1, 3, 4, 5, 8, 10 };
        magicIndex = findMagicIndex(arr2);
        printArray("Input Array", arr2);
        System.out.printf("Magic index is %d, value at %d is %d\n", magicIndex, magicIndex, arr2[magicIndex]);
    }

    /**
     * A magic index in an array A[0…n-1] is defined to be an index such that A[i] =
     * i. Given a sorted array of distinct integers, write a method to find a magic
     * index if one exists, in an array A.
     */
    private static int findMagicIndex(int[] arr) {
        int result = -1;
        if (arr == null) {
            System.err.println("findMagicIndex Error: Input array null");
            return result;
        }
        int low = 0, high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (mid == arr[mid]) {
                result = mid;
                break;
            } else if (mid < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return result;
    }

    /**
     * Given a sorted array of n integers that has been rotated an unknown number of
     * times, write code to find an element in the array. You may assume that the
     * array was originally sorted in increasing order.
     */
    private static void arrayProblem3() {
        System.out.println(
                "Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array");
        System.out.println("==================================================================");
        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5 };
        printArray("Input Array", arr);
        System.out.println("Searching 2...");
        findElementInRotatedSortedArray(arr, 2);

        printArray("Input Array", arr);
        System.out.println("Searching 5...");
        findElementInRotatedSortedArray(arr, 5);

        printArray("Input Array", arr);
        System.out.println("Searching 8...");
        findElementInRotatedSortedArray(arr, 8);

        printArray("Input Array", arr);
        System.out.println("Searching 7...");
        findElementInRotatedSortedArray(arr, 7);

        printArray("Input Array", arr);
        System.out.println("Searching 1...");
        findElementInRotatedSortedArray(arr, 1);
    }

    private static void findElementInRotatedSortedArray(int[] arr, int searchValue) {
        int low = 0, high = (arr.length - 1);
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (searchValue == arr[mid]) {
                System.out.printf("Element found at index %d, value %d\n", mid, arr[mid]);
                break;
            } else if ((searchValue > arr[high] && searchValue >= arr[low]) || searchValue < arr[mid]) {
                high = mid - 1;
            } else if (searchValue > arr[mid]) {
                low = mid + 1;
            }
        }
    }

    /**
     * Given an array that contains numbers from 1 to n-1 and exactly 1 duplicate,
     * find that duplicate.
     */
    private static void arrayProblem4() {
        System.out.println(
                "Given an array that contains numbers from 1 to n-1 and exactly 1 duplicate, find that duplicate.");
        System.out.println("==================================================================");
        int[] arr = new int[] { 5, 4, 1, 3, 1 };
        int result = findSingleDuplicateElement(arr);
        printArray("Input Array", arr);
        System.out.printf("Duplicate value: %d\n", result);

        arr = new int[] { -2, 1, 2, 8, 6, 5, 4, 4 };
        result = findSingleDuplicateElement(arr);
        printArray("Input Array", arr);
        System.out.printf("Duplicate value: %d\n", result);

        arr = new int[] { -2, 1, 2, 8, 6, 5, 6, 4 };
        result = findSingleDuplicateElement(arr);
        printArray("Input Array", arr);
        System.out.printf("Duplicate value: %d\n", result);

        arr = new int[] { -2, 1, -2, 8, 6, 5, 4, 3 };
        result = findSingleDuplicateElement(arr);
        printArray("Input Array", arr);
        System.out.printf("Duplicate value: %d\n", result);
    }

    private static int findSingleDuplicateElement(int[] arr) {
        int result = -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : arr) {
            if (map.containsValue(value)) {
                result = value;
                break;
            } else {
                map.put(value, value);
            }
        }
        return result;
    }

    /**
     * Search an element in an array where difference between adjacent elements is
     * 1. For example: arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} Search for 3 and
     * Output: Found at index 7
     */
    private static void arrayProblem5() {
        System.out.println("Search an element in an array where difference between adjacent elements is 1.");
        System.out.println("==================================================================");
        int[] arr = new int[] { 8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3 };
        findWithAdjacentDiffByOne(3, arr);
        arr = new int[] { 2, 8, 9, 8, 7, 6, 5, 5, 4, 5, 4, 3 };
        findWithAdjacentDiffByOne(8, arr);
    }

    private static void findWithAdjacentDiffByOne(int searchValue, int[] arr) {
        if (arr == null) {
            System.out.println("Input Array is null.");
            return;
        } else if (arr.length < 3) {
            System.out.println("Array length needs to be 3 or more.");
            return;
        }

        int resultIndex = -1;

        for (int i = 1; i < arr.length - 1; i++) {
            if (searchValue == arr[i] && Math.abs(arr[i - 1] - searchValue) == 1
                    && Math.abs(arr[i + 1] - searchValue) == 1) {
                resultIndex = i;
                break;
            }
        }

        printArray("Input Array", arr);
        if (resultIndex != -1) {
            System.out.printf("Value %d found at index %d, Tuple is %d, %d, %d\n", searchValue, resultIndex,
                    arr[resultIndex - 1], arr[resultIndex], arr[resultIndex + 1]);
        } else {
            System.out.println("No value found with adjacent element difference of 1");
        }
    }

    /**
     * Given an array of numbers, split the array into two where one array contains
     * the sum of n-1 numbers and the other array with all the n-1 elements.
     * Example: [5, 2, 7, 6, 20] Response: [5,2,7,6] [20]
     */
    private static void arrayProblem6() {
        System.out.println(
                "Given an array of numbers, split the array into two where one array contains the sum of n-1 numbers and the other array with all the n-1 elements.");
        System.out.println("==================================================================");
        int arr[] = { 5, 2, 7, 6, 20 };
        splitArrayAndSum(arr);
        
        arr = new int[]{ 20, 2, 7, 6, 5 };
        splitArrayAndSum(arr);
        
        arr = new int[]{ 5, 2, 20, 6, 7 };
        splitArrayAndSum(arr);
        
    }

    private static void splitArrayAndSum(int[] arr) {
        int[] arrayElements = new int[arr.length - 1];
        int savedMaxIndex = 0;
        int[] arrayMax = new int[1];
        arrayMax[0] = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arrayMax[0]) {
                savedMaxIndex = i;
                arrayMax[0] += arr[i];
            }
            arrayElements[i] = arr[i];
        }

        if (arr[arr.length - 1] >= arrayMax[0]) {
            arrayMax[0] = arr[arr.length - 1];
        } else {
            arrayElements[savedMaxIndex] = arr[arr.length - 1];
            arrayMax[0] = arr[savedMaxIndex];
        }

        printArray("Input Array", arr);
        printArray("Array of elements without Sum", arrayElements);
        printArray("Array with sum of elements", arrayMax);
    }

    private static void printArray(String message, int[] array) {
        System.out.print(message);
        System.out.print(" [");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}