class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder s = new StringBuilder();
        
        if(strs.length == 0){
            return s.toString();
        }
        
        for(int i=0; i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(i>=strs[j].length()){
                    return s.toString();
                }
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    return s.toString();
                }
            }
            s.append(strs[0].charAt(i));
                
            System.out.println(s);
        }
        return s.toString();
        
    }
}