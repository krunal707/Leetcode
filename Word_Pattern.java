class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] words = str.split(" "); // To add to notes
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        
        for(int i=0; i<pattern.length(); i++){
            char curr = pattern.charAt(i);
            if(map.containsKey(curr)){
                if(!map.get(curr).equals(words[i])){
                    return false;
                }
                
            }else{
                if(map.containsValue(words[i])){
                    return false;
                }   
                map.put(curr, words[i]);
            }
        }
        
        return true;
    }
}