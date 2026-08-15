class Solution {
    private void swap(int[] nums, int i, int j){
        int a = nums[i];
        int b = nums[j];
        nums[j] = a;
        nums[i] = b;
    }
    public void sortColors(int[] nums) {
        // take i and j, i represents position of 0 and j represents position of 2
        int i = 0;
        int j = nums.length -1;
        int size = nums.length;
        int k = 0;
        while(k<=j){
            if(nums[k] == 0){
                swap(nums, i, k);
                i++;
                k++;
            } else if (nums[k]==2){
                swap(nums, j, k);
                j--;
            } else if(nums[k] == 1){
                k++;
            }
        }
    }
}