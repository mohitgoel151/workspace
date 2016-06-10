package learn.ds.array;

/**
 * Find duplicates in O(n) time and O(1) extra space
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times. 
 * Find these repeating numbers in O(n) and using only constant memory space.
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6. 
 * This problem is an extended version of following problem.
 * 
 * @author mohit
 *      
 * http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 *
 */
public class MultipleInArray {
    
    public void execute() {
        int[] arr = {1, 2, 3, 1, 3, 6, 6};
        printRepeating(arr);
    }

    private void printRepeating(int[] arr) {
        int i;
        int size = arr.length;
        
        System.out.println("The repeating elements are: \n");
        for (i = 0; i < size; i++)
        {
          if (arr[Math.abs(arr[i])] >= 0)
            arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
          else
              System.out.println(Math.abs(arr[i]));
        }
        
    }

}
