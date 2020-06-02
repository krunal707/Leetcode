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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        int level = 1;
        if(root != null)
            s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> values = new ArrayList<>();
            
            if(level%2 == 0){
            int size = s2.size();
            
            for(int i=0; i<size; i++){
                TreeNode n = s2.pop();
                values.add(n.val);
                if(n.right != null){
                    s1.push(n.right);
                }
                 if(n.left != null){
                    s1.push(n.left);
                }
            }
            }
            else{
            int size = s1.size();
            
            for(int i=0; i<size; i++){
                TreeNode n = s1.pop();
                values.add(n.val);
                 if(n.left != null){
                    s2.push(n.left);
                }
                if(n.right != null){
                    s2.push(n.right);
                }
               
                 
            }
            }
            
            res.add(values);
            level++;
            
        }
        
        
        return res;
        
    }
    
   
}