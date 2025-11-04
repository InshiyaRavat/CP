//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//Return the sum of the three integers.
//solved using 2 pointer method.

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        java.util.Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        if(nums.length == 3){
            return closestSum;
        }

        for(int i = 0;i<nums.length -2;i++){
            int left = i+1;
            int right = nums.length -1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }

                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else{
                    return sum;
                }
            }
        }

        return closestSum;
    }
}
