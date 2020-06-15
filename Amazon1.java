// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.*;
import java.util.PriorityQueue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution


{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public ArrayList<String> popularNToys(int numToys, 
	                                      int topToys, 
                                          List<String> toys, 
										  int numQuotes, 
										  List<String> quotes)
    {
        // WRITE YOUR CODE HERE
        
        Map<String, Integer> freqMap = new HashMap<>();
        Map<Integer, ArrayList<String>> invFreqMap = new HashMap<>();
        ArrayList<String> ans = new ArrayList();
        ArrayList<String> fullAns = new ArrayList();
        if (numToys < 1) {
            return ans;
        } else {
            for (String quote : quotes) {
                for (String toy : toys) {
                    if (quote.toLowerCase().contains(toy.toLowerCase())) {
                        freqMap.put(toy, freqMap.getOrDefault(toy, 0) + 1);
                    }
                }
            }

            for (String toy : freqMap.keySet()) {
                if(!invFreqMap.containsKey(freqMap.get(toy))){
                    invFreqMap.put(freqMap.get(toy),new ArrayList<>());
                }
                invFreqMap.get(freqMap.get(toy)).add(toy);
            }

            ArrayList<Integer> freqs = new ArrayList<>(invFreqMap.keySet());
            Collections.sort(freqs, Collections.reverseOrder());

            for (int i = 0; i < freqs.size(); i++) {
                Collections.sort(invFreqMap.get(freqs.get(i)));
                fullAns.addAll(invFreqMap.get(freqs.get(i)));
            }

            for (int i = 0; i < topToys && i < fullAns.size(); i++) {
                ans.add(fullAns.get(i));
            }

        }
        return ans;
       
        
    }
    // METHOD SIGNATURE ENDS
}