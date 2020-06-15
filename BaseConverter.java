// Java Program to convert decimal to any given base 
import java.lang.*;  
import java.io.*;  
import java.util.*;  
  
class Main 
{ 


// From Decimal to given base


// 'A' is returned for 10. 'B' for 11 
static char reVal(int num) 
{ 
    if (num >= 0 && num <= 9) 
        return (char)(num + 48); 
    else
        return (char)(num - 10 + 65); 
} 
static String fromDeci(int base1, int inputNum) 
{ 
    String s = ""; 
  
    while (inputNum > 0) 
    { 
        s += reVal(inputNum % base1); 
        inputNum /= base1; 
    } 
    StringBuilder ix = new StringBuilder();  
  
        // append a string into StringBuilder input1  
        ix.append(s);  
  
    // Reverse the result 
    return new String(ix.reverse()); 
}

// To Decimal from given base

static int val(char c) 
{ 
    if (c >= '0' && c <= '9') 
        return (int)c - '0'; 
    else
        return (int)c - 'A' + 10; 
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

// Driver code 
public static void main (String[] args) 
{ 
    int inputNum = 348, base1 = 16; 
    System.out.println("Equivalent of " + inputNum + " in base "+base1+" is " + fromDeci(base1, inputNum)); 
    int base2 = 16; 
    String s = "15C";
    System.out.println("Equivalent of " + s + " of base "+base2+" is " + toDeci(s, base2)); 
                            
} 
} 