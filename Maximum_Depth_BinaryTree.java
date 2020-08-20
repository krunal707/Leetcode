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
    public int maxDepth(TreeNode root) {
        
        // DFS
        
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right)+1;
        
        
        
        // BFS
        
//         if(root == null){
//             return 0;
//         }
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         int depth = 0;
        
//         queue.add(root);
        
//         while(!queue.isEmpty()){
            
//             depth++;
            
//             int len = queue.size();
//             for(int i=0; i<len; i++){
//                 TreeNode curr = queue.poll();
//                 System.out.println("curr" + curr.val + "depth" + depth);
//                 if(curr.left != null){
//                     queue.add(curr.left);
//                 }
//                 if(curr.right != null){
//                     queue.add(curr.right);
//                 }
                
//             }
           
//         }
        
        
//         return depth;
        
    }
}