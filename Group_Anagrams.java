class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      /*  
        List<List<String>> result = new ArrayList<>();
        boolean[] pivot = new boolean[strs.length];
        
        
       int[] chars = new int[26];
        
        for(int i=0; i<strs.length-1; i++){
            
             List<String> temp = new ArrayList<String>();
            
            // Adding characters to the char array
            for(int c=0; c<strs[i].length(); c++){
                chars[strs[i].charAt(c) - 'a']++;
            }
            
            temp.add(strs[i]);
            
            outer: for(int j=i+1; j<strs.length; j++){
                
               
                
                 for(int c=0; c<strs[j].length(); c++){
                    chars[strs[j].charAt(c) - 'a']--;
                 }
                
                for(int k: chars){
                     if(k != 0){
                        break outer;
                    }
                }
                
                temp.add(strs[j]);
                
                
                
                
            }
            
            result.add(temp);
        
        
    }
        
        return result; */
        
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca); 
            
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        
        return new ArrayList(ans.values());
   


        
        
    }
}