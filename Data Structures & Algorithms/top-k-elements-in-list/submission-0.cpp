class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int,int> mp;

        for(int el : nums){
            mp[el]++;
        }
        vector<pair<int,int>> v;
        for(auto el : mp){
            v.push_back(el);
        }
        sort(v.begin(), v.end(), [](pair<int,int>a, pair<int,int>b){
            return a.second>b.second;
            });

        vector<int> ans;
        int i=0;
        while(k--){
            ans.push_back(v[i].first);
            i++;
        }
        return ans;
    }
};
