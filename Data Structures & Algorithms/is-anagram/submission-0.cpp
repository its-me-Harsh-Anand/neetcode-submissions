class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        unordered_map<char,int> m;

        for(char el : s){
            m[el]++;
        }

        for(char el : t){
            if(m.find(el)==m.end()) return false;
            m[el]--;
        }
        for(auto el : m){
            if(el.second > 0) return false;
        }
        return true;
    }
};
