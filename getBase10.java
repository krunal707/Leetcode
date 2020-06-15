class Main {
  static int val(char c) 
{ 
    if (c >= '0' && c <= '9') 
        return (int)c - '0'; 
    else
        return (int)c - 'A' + 10; 
} 
  public static void main(String[] args) {
   
  int res = toDeci("534", 8);
  
  System.out.println("GFG: " + res);
  }

  static int toDeci(String str,  
                  int base) 
{ 
    int len = str.length(); 
    int power = 1; // Initialize  
                   // power of base 
    int num = 0; // Initialize result 
    int i; 
  
    // Decimal equivalent is  
    // str[len-1]*1 + str[len-2] * 
    // base + str[len-3]*(base^2) + ... 
    for (i = len - 1; i >= 0; i--) 
    { 
        // A digit in input number  
        // must be less than  
        // number's base 
        if (val(str.charAt(i)) >= base) 
        { 
        System.out.println("Invalid Number"); 
        return -1; 
        } 
  
        num += val(str.charAt(i)) * power; 
        power = power * base; 
    } 
  
    return num; 
} 
}