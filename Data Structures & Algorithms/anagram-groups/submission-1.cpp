class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;

        for(string el : strs){

            vector<int> freq(26, 0);
            for(char e : el){
                freq[e-'a']++;
            }

            string key = to_string(freq[0]) + ",";
            for(int i =1; i<26; i++){
                key += to_string(freq[i]) + ",";
            }

            mp[key].push_back(el);
        }

        vector<vector<string>> ans;
        for(auto el : mp){
            ans.push_back(el.second);
        }
        return ans;
    }
};
