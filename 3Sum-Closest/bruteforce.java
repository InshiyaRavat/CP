// 3 loop o(n^3)

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> resultArray = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            for (int j=i+1; j< nums.length - 1; j++){
                for(int k=j+1 ;k<nums.length; k++){
                    int sumOfTwo = nums[j] + nums[k];
                    resultArray.add(sumOfTwo + nums[i]);
                    if((sumOfTwo + nums[i]) == target){
                        return target;
                    }
                }
            }
        }
        // i = 0; j = 1; k = 2; m = 0; [2]
        //i = 0; j = 1; k = 3; m = 1 [2, -3]
        // i = 0; j = 2; k = 3; m = 2; [2, -3, -4]
        // i = 1; j = 2; k = 3; m = 3; [2, -3, -4, -1]
        
        int minDistance = Integer.MAX_VALUE;
        int closest = 0;
        // goal: to find closest to target in resultArray
        for(int x : resultArray){
            int distance = Math.abs(x - target);
           if(distance < minDistance){
            minDistance = distance;
            closest = x;
           }
        }

        // i = 0; minDistance = infinity; distnace = 1; minDistance = 1;
        // i = 1; minDistance = 1; distance = 4;
        // i = 2; minDistance = 1; distance = 5;
        // i = 3; minDistance = 1; distance = 2;

        return closest;
    }
}
