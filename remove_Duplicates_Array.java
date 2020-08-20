class Solution {
    public int removeDuplicates(int[] nums) {

    // So for this problem my intuition was to have 2 pointers and iterate over the array one time and then perform some operations
        
        int first = 0;
        int second = 1;
        
        
        while(second < nums.length){
            if(nums[first] == nums[second]){
                second++;
            }
            else if(nums[second] > nums[first]){
                nums[first+1] = nums[second];
                first++;
                second++;
            }
        }
        
        return first+1;
        
    }
}