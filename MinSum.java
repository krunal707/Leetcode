import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.Collection;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY num
     *  2. INTEGER k
     */

    public static int minSum(List<Integer> nums, int k) {
    // Write your code here
        if (nums.isEmpty() || k == 0)
            return 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        pQueue.addAll(nums);
        while (k-- > 0) {
            pQueue.add((int) Math.ceil(pQueue.poll() / 2d));
        }

        return pQueue.stream().mapToInt(a -> a).sum();


 
    }

   

}

public class Solution {