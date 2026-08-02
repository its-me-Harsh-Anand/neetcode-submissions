class Solution {
    private void mergeSort(int[] nums, int start, int end){
        if(start>= end) return;

        int mid = start + (end-start)/2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);

        int[] ans = new int[end-start+1];
        int k = ans.length -1;

        int i = mid;
        int j = end;
        while(i>=start && j>mid){
            if(nums[i]>nums[j]){
                ans[k] = nums[i];
                i--;
            } else {
                ans[k] = nums[j];
                j--;
            }
            k--;
        }
        while(i>=start){
            ans[k] = nums[i]; 
            i--;
            k--;
        }

        
        while(j>mid){
            ans[k] = nums[j]; 
            k--;
            j--;
        }
        k = 0;
        i = start;
        for(; i<=end; i++){
            nums[i] = ans[k++];
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}