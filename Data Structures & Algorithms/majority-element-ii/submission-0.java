class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int el : nums){
            map.put(el, map.getOrDefault(el, 0)+1);
        }

        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, Integer> el : map.entrySet()){
            if(el.getValue() > n/3){
                ans.add(el.getKey());
            }
        }

        return ans;
    }
}