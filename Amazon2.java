// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for(int i = 0; i < inputList.size(); i++) {
            lastOccurrence.put(inputList.get(i), i);
        }
        List<Integer> ret = new LinkedList<>();
        int len = 0;
        int stop = 0;
        for (int i = 0; i < inputList.size(); i++) {
            len++;
            stop = Math.max(stop, lastOccurrence.get(inputList.get(i)));
            if (i == stop) {
                ret.add(len);
                len = 0;
            }
        }
        return ret;
    }
    // METHOD SIGNATURE ENDS
}