1. Two Sum
Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].



class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Brute Force
        /*
        int[] targets = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    targets[0] = i;
                    targets[1] = j;
                    return targets;
                }
            }
        
        }
        return targets;  */
        
        int[] targets = new int[2];
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            int value = target - nums[i];
            
            if(numbers.containsKey(value)){
                targets[1] = i;
                targets[0] = numbers.get(value);
                return targets;
            }
            
            numbers.put(nums[i], i);
            
        }
        return targets;
        
        
        
        
    }
}