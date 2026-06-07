class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        int j = n-1;
        int i = 0;
        while(j>=0 and nums[j]==val){
            j--;
        }
        while(i<j){
            if(nums[i]==val){
                swap(nums[i], nums[j]);    
            }
            while(j>=0 and nums[j]==val){
                j--;
            }
            i++;
        }
        return j+1;
    }
};