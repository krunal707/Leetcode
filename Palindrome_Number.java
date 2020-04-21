class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }
        if(x<0 || x%10 == 0){
            return false;
        }
        
        //1. Convert into int array and then process with normal palindome 
        
        //2 More easy solution is to 
        //  1. Divide the number in half
        //  2. Reverse 2nd half and then compare the two
        
        int reversed = 0;
        while(x>reversed){
            reversed = (reversed*10) + x%10;
            
            x /= 10;
        }
        
        return reversed == x || x == reversed/10;
    }
}