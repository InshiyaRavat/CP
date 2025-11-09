class Solution {
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used){
        if(nums.length == current.size()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i] = true;
                current.add(nums[i]);
                backtrack(nums, result, current, used);
                current.remove(current.size() -1);
                used[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);

        return result;
    }
}
