class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void siftDown(int[] nums, int i, int n){
        if(i>=n) return;

        int lchild = 2*i + 1;
        int rchild = 2*i + 2;

        int maxChild = i;
        if(lchild < n && nums[maxChild]<nums[lchild]){
            maxChild = lchild;
        }
        if(rchild < n && nums[maxChild] < nums[rchild]){
            maxChild = rchild;
        }
        if(maxChild == i) return;
        swap(nums, i, maxChild);
        siftDown(nums, maxChild, n);
    }
    private void heapify(int[] nums){
        int n = nums.length;
        for(int i=(n/2)-1; i>=0; i--){
            siftDown(nums, i, n);
        }
    }
    public int[] sortArray(int[] nums) {
        heapify(nums);

        int lastIndex = nums.length -1;
        while(lastIndex > 0){
            swap(nums, 0, lastIndex);
            siftDown(nums, 0, lastIndex);
            lastIndex--;
        }
        return nums;
    }
}