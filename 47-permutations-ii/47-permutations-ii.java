class Solution {
    public void helper(int[] arr, int idx, HashSet<List<Integer>> ans, List<Integer> sub, boolean[] visited) {
        if(idx == arr.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub.add(arr[i]);
                helper(arr, idx + 1, ans, sub, visited);
                sub.remove(sub.size() - 1);
                visited[i] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, 0, ans, new ArrayList<>(), visited);
        return new ArrayList<>(ans);
    }
}