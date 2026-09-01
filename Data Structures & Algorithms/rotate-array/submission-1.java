class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        while(k>0){
            int ind = n-1;

            while(ind>0){
                swap(nums, ind, ind-1);
                ind--;
            }
            k--;
        }
    }
}