class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        while(i<n){
            int prev = nums[i];
            while(true){
                if(i == nums[i]-1 || nums[i] <=0 || nums[i]>n){
                    break;
                }
                swap(nums, i, nums[i]-1);
                if(nums[i]==prev) break;
                else prev = nums[i];
            }
            i++;
        }

        for(int k=0; k<n; k++){
            if(nums[k] != k+1) return k+1;
        }
        return n+1;
    }
}