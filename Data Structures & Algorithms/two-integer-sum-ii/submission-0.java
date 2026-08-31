class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int n = nums.length;

        while(i<j){
            if(nums[i] + nums[j] == target){
                break;
            } else if (nums[i] + nums[j] > target){
                j--;
            } else {
                i++;
            }
        }

        int[] ans = {i+1, j+1};
        return ans;
    }
}
