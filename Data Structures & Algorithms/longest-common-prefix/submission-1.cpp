class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.size() == 0) return "";
        int lsl = INT_MAX;
        for(string el : strs){
            lsl = min(lsl, (int)el.size());
        }

        for(int i=0; i<lsl; i++){
            char temp = strs[0][i];
            for(string el : strs){
                if(temp != el[i]) return el.substr(0, i);
            }
        }
        return strs[0].substr(0, lsl);
    }
};