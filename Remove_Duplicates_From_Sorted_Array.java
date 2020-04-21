class Solution {
    public int removeDuplicates(int[] nums) {
        
       int length = 1;
       int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }
            else{
                length++;
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return length;
        
    }
}