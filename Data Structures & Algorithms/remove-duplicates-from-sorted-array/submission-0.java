class Solution {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int removeDuplicates(int[] nums) {
        int i = 0; // denote unique element
        int n = nums.length;
        int j = 0;
        while(j<n){
            while(j<n && nums[j]==nums[i]){
                j++;
            }
            if(j==n) return i+1;

            int k = j;
            while(k != i+1){
                swap(nums, k, k-1);
                k--;
            }
            i++;
            j++;
        }
        return i+1;
    }
}