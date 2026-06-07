class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<string, vector<string>> mp;

        for(string el : strs){
            string original = el;
            sort(el.begin(), el.end());
            mp[el].push_back(original);
        }

        vector<vector<string>> ans;
        for(auto el : mp){
            ans.push_back(el.second);
        }
        return ans;
    }
};
