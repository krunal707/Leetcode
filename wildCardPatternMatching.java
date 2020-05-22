import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Node{
    boolean isWord;
    Node[] children;
    public Node(){
        isWord = false;
        children = new Node[26];
    }
}

class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }
    
    public void construct(String[] words){
        for(String word : words){
            Node node = root;
            for(char c : word.toCharArray()){
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new Node();
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;
        }
    }
    
/*
#    def isMemberHelper(word, node):
#     if word == "" and node.is_end:
#         return True
# 
#     if word == "":
#         return False
# 
#     next_char, rest_of_string = word[:1], word[1:]
# 
#     if next_char == "*":
#         for key, child in node.children.items():
#             if isMemberHelper(rest_of_string, child):
#                 return True
#     else:
#         if next_char in node.children:
#             return isMemberHelper(rest_of_string, node.children[next_char])
# 
#     return False


*/ 
    
    
    public boolean search(String query, Node node){
        
        // boolean isCompleted = false;
        
        // for(int i=0; i<query.length(); i++){
        //     char c = query.charAt(i);
        //     if(node.children[c - 'a'] == null && c != '*'){
        //         return false;
        //     }
        //     if(c == '*'){
                
        //     }
        //     node = node.children[c - 'a'];
        //     isCompleted = node.isWord;
            
            
        // }
        // if(isCompleted){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        
        if(query == "" && node.isWord){
            return true;
        }
        
        if(query == ""){
            return false;
        }
        
        // char ch = (char) query.substring(0,1);
        char ch = query.charAt(0);
        String rest_of_string = query.substring(1);
        
//         #     if next_char == "*":
// #         for key, child in node.children.items():
// #             if isMemberHelper(rest_of_string, child):
// #                 return True
// #     else:
// #         if next_char in node.children:
// #             return isMemberHelper(rest_of_string, node.children[next_char])
// # 
// #     return False
        
        if(ch == '*'){
            for(int i=0; i<node.children.length; i++){
                if(node.children[i] != null){
                    if(search(rest_of_string, node.children[i])){
                        return true;
                    }
                    
                        
                }
            }
        }
        else{
            if(node.children[ch - 'a'] != null){
                return search(rest_of_string, node.children[ch - 'a']);
            }
            
        }
         
        return false;
    }
}

class Solution {
    /*
     * Complete the 'isMember' function below.
     *
     * The function is expected to return a BOOLEAN.
     * The function accepts following parameters:
     *  1. STRING_ARRAY words
     *  2. STRING query
     */
    static Trie trie;

    public static boolean isMember(String[] words, String query) {
        return trie.search(query,trie.root);     
    }

    public static void main(String[] args) throws IOException {
        String[] words = {"foo", "fo", "bar", "baz"};
        trie = new Trie();
        
        trie.construct(words);
        System.out.println(isMember(words, "foo"));   // true   (because 'foo' exists in the list of words)
        System.out.println(isMember(words, "hello")); // false  (because 'hello' does NOT exists in the list of words)
        
        System.out.println(isMember(words, "f*o"));   // true  (because the '*' matches the first 'o' in foo)
        System.out.println(isMember(words, "**"));    // false (no two letter words)
        
        System.out.println(isMember(words, "*az"));   // Is this true or false?
    }
}

