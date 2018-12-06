/**
    
    Always choose the first of UNUSED duplicate numbers 

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result, nums, new ArrayList<Integer>(), used);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> cur, boolean[] used){
        
        if(cur.size() == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i ++){
            
            // always choose the first one of unused dup
            if(used[i] || (i != 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            
            cur.add(nums[i]);
            used[i] = true;
            dfs(result, nums, cur, used);
            used[i] = false;
            cur.remove(cur.size()-1);

        }
        
    }
}