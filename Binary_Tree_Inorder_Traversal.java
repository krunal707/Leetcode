/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Using DFS/recursion
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if(root != null){
            inorderTraversal(root, output);
        }
        
       
        return output;
        
    }
    
    private void inorderTraversal(TreeNode curr, List<Integer> output){
        
         if(curr.left != null){
            inorderTraversal(curr.left, output);
        }
        output.add(curr.val);
        if(curr.right != null){
            inorderTraversal(curr.right, output);
        }
    }
}
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
            
        }
           
        return output;
        
    }
    
    
}