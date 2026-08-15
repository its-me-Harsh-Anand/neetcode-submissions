class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] leftPrefixMul = new int[size];
        int[] rightPrefixMul = new int[size];

        for(int i=0; i<size; i++){
            leftPrefixMul[i] = (i==0 ? 1 : leftPrefixMul[i-1])*nums[i];
            rightPrefixMul[size-i-1] = (size-i == size? 1 : rightPrefixMul[size-i]) * nums[size-i-1]; 
        }

        int[] ans = new int[size];
        for(int i=0; i<size; i++){
            ans[i] = (i==0 ? 1 : leftPrefixMul[i-1]) * (i==size-1 ? 1: rightPrefixMul[i+1]);
        }
        return ans;
    }
}  
