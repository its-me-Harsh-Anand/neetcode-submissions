class Solution {
    public int longestConsecutive(int[] nums) {
    	HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0; i<nums.length; i++){
        	set.add(nums[i]);
        }

        ArrayList<Integer> startPoints = new ArrayList<Integer>();

        for(int el : nums){
        	if(!set.contains(el-1)){
        		startPoints.add(el);
        	}
        }
        int ans = 0;
        for(Integer el : startPoints){
        	Integer p = el;
        	int count = 0;
        	while(set.contains(p)){
        		count++;
        		p++;
        	}
        	ans = Math.max(ans, count);
        }
        return ans;
    }
}