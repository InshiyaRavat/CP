class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 4){
            long sum = (long)nums[0] + nums[1] + nums[2] + nums[3];
            if(sum == target){
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        }

        Arrays.sort(nums);
      
        for(int i=0; i<nums.length-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int newTarget = target - nums[i];
            for(int j=i+1 ; j<nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length -1;
                while (left < right){
                    long sum = (long)nums[j] + nums[left] + nums[right];
                    if(sum > newTarget){
                        right--;
                    }
                    else if(sum < newTarget){
                        left++;
                    }
                    else if(sum == newTarget){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left],nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]) left++;
                        while(left < right && nums[right] == nums[right+1]) right--;
                    }
                }
            }
        }
        return result;
    }
}
