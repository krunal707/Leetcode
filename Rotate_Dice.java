// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        if(A.length == 0){
            return 0;
        }
        
        int flip_count;
        int min_flip_count = Integer.MAX_VALUE;
        
        for(int value: A){
            flip_count = 0;
            for(int i: A){
                if(value == i){
                    flip_count += 0;
                    
                }
                else if (value + i == 7){
                    flip_count += 2;
                }
                else{
                    flip_count += 1;
                }
            }
            if(flip_count < min_flip_count){
                min_flip_count = flip_count;
            }
        }
        
        return min_flip_count;
        
    }
    
}