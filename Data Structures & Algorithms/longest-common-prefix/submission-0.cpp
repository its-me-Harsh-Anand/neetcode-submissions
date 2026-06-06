class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0) return "";
        int lsl = INT_MAX;
        for(string el : strs){
            lsl = min(lsl, (int)el.size());
        }

        for(int i=0; i<lsl; i++){
            unordered_set<char> s;
            for(string el : strs){
                s.insert(el[i]);
                if(s.size()>1) {
                    if(i==0) return "";
                    return el.substr(0, i);
                }
            }
        }
        return strs[0].substr(0, lsl);
    }
};