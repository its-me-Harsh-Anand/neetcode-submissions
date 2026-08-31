class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();

        for(int i=0; i<n; i++){
            int j=i+1, k = n-1;

            while(j<k){
                int sum = nums[j]+nums[k]+nums[i];
                if(sum == 0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    s.add(l);
                    j++;
                    k--;
                } else if(sum<0){
                    j++;
                } else {
                    k--;
                }
            }
        }

        for(List<Integer> el : s){
            ans.add(el);
        }
        return ans;
    }
}