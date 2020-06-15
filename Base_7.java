class Solution {
    public String convertToBase7(int num) {
        
        StringBuilder s = new StringBuilder();
        int convertToBase = 7;
        boolean negative = false;
        
        if(num == 0){
            return "0";
        }
        if(num<0){
            negative = true;
            num = num*(-1);
        }
        
        while(num > 0){
            s.append("" + num % convertToBase);
            num /= convertToBase;
        }

        
        Integer t = Integer.parseInt(s.reverse().toString());
        System.out.println(t);
        
        if(negative){
            t = t*(-1);
        }
        
        return t.toString();
        
    }
}