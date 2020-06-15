 public int[] scan(String string, int ptr){
    int num = Character.getNumericValue(string.charAt(ptr));

    while(ptr < string.length() && Character.isDigit(string.charAt(ptr))){

      num *= 10;
      num += Character.getNumericValue(string.charAt(ptr)); 
      ptr++;
    }
      return new int[] {num, ptr};
    
  }
 

 public boolean solution(String S, String T) {
       // write your code in Java SE 8
   
     boolean is_digit_1 = false;
     boolean is_digit_2 = false;
 
     int digits_1 = 0, digits_2 = 0;
     int ptr1 = 0, ptr2 = 0;
     while (ptr1 <= S.length() && ptr2 <= T.length()){
       if (is_digit_1 || is_digit_2){
         if(is_digit_1){
 
           digits_1--;
           if(digits_1 == 0)
             is_digit_1 = false;
         }
         else{
           ptr1++;
           if(ptr1 < S.length() && Character.isDigit(S.charAt(ptr1)))
           {
             int[] res = new int[2];
            
             res = scan(S, ptr1);
             is_digit_1 = true;
             digits_1 = res[0];
             ptr1 = res[1];
           }
         }
 
 
       if(is_digit_2){
 
           digits_2--;
           if(digits_2 == 0)
             is_digit_2 = false;
         }
         else{
           ptr2++;
           if(ptr2 < T.length() && Character.isDigit(T.charAt(ptr2)))
           {
             int[] res = new int[2];
            
             res = scan(T, ptr2);
             is_digit_2 = true;
             digits_2 = res[0];
             ptr2 = res[1];
           }
         }
       continue;
       }
 
       if(ptr1 >= S.length() || ptr2 >= T.length())
         break;
 
       boolean is_digit = false;
       if(Character.isDigit(S.charAt(ptr1))){
         int[] res = new int[2];
            
             res = scan(S, ptr1);
             is_digit_1 = true;
             digits_1 = res[0];
             ptr1 = res[1];
             is_digit = true;
 
       }
 
       if(Character.isDigit(T.charAt(ptr2))){
         int[] res = new int[2];
            
             res = scan(T, ptr2);
             is_digit_2 = true;
             digits_2 = res[0];
             ptr2 = res[1];
             is_digit = true;
 
       }
 
       if(is_digit)
         continue
 
       if(S.charAt(ptr1) != T.charAt(ptr2))
         return false;
 
       ptr1++; ptr2++;
     }
 
     if( !is_digit_1 && !is_digit_2 && ptr1 == S.length() && ptr2 == T.length())
       return true;
    
     return false;
 
   }
