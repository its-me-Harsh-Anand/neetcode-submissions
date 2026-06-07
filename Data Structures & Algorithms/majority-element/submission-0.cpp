class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int,int> mp;
        for(int el : nums){
            mp[el]++;
        }
        
        for(auto el : mp){
           if(el.second > ((int)nums.size()/2)) return el.first;
        }
        return 0;
    }
};