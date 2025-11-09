class Solution {

    private void backtrack(int remaining, int start, int[] candidates, List<List<Integer>> result, List<Integer> current){
        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i<candidates.length; i++){
            if(remaining < candidates[i]){
                break;
            }

            if(i > start && candidates[i] == candidates[i-1]) continue;

                current.add(candidates[i]);
                backtrack(remaining - candidates[i], i+1, candidates, result, current);
                current.remove(current.size() -1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(target, 0, candidates, result, new ArrayList<Integer>());

        return result;
    }
}
