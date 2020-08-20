class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        
        if(nums.length == 0 || nums == null){
            return range;
        }
        if(nums.length == 1 && nums[0] == target){
            range[0] = 0;
            range[1] = 0;
            return range;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        
        
        
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                System.out.println("mid is " +mid);
                int start = mid;
                int end = mid;
                while(nums[start] == target){
                    System.out.println("start is " +start);
                    start--;
                    if(start < 0){
                        break;
                    }
                }
                while(nums[end] == target){
                    System.out.println("end is " +end);
                    end++;
                    if(end >= nums.length){
                        break;
                    }
                }
                range[0] = start+1;
                range[1] = end-1;
                return range;
                
            }else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return range;
        
    }
}