public class Solution {
    public int reverse(int x) {
       /* long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
       */
        
        int negative = 1;
        if(x<0){
            negative = -1;
            x *= -1;
        }
        
        long reversed = 0;
        while(x > 0){
            reversed = (reversed*10) + (x % 10);
            x /= 10;
        }
        
        if(reversed > Integer.MAX_VALUE){
            return 0;
        }
        return (int)reversed*negative;
        
    }
}