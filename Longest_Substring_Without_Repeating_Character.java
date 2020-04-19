class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        
        
        int maxLength = 1;
        
        int i = 0;
        
        if(s.length() == 2 && s.charAt(i) != s.charAt(i+1)){
           
                maxLength += 1;
            
        }
        
        while(i < s.length()-1 && s.length() > 2){
            
          //  HashMap<String, Integer> map = new HashMap<>();
            Set<Character> hashset = new HashSet<>();
            int length = 1;
            int j = i+1;
            hashset.add(s.charAt(i));
            
            while(j < s.length() && !hashset.contains(s.charAt(j)) ){
               
                hashset.add(s.charAt(j));
                length += 1;
                j += 1;
                 
                
            }
            if(length > maxLength){
                maxLength = length;
            }
            
            i++;
           
            
        }
        
        return maxLength;
        
        
        
    }
}