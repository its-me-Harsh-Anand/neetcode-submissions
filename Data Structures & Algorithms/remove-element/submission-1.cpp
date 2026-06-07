class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        vector<int> temp;
        for(int el : nums){
            if(el!=val) temp.push_back(el);
        }
        for(int i=0; i<temp.size(); i++){
            nums[i]=temp[i];
        }
        return temp.size();
    }
};