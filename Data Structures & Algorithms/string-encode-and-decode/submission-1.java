class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String el : strs){
            Integer size = el.length();
            encoded += size + "$" + el;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while(i<str.length()){
            if (Character.isDigit(str.charAt(i))) {
                int num = 0;

                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i++; // to surpass $
                String temp = "";
                int k = i;
                for(; k<num+i; k++){
                    temp += str.charAt(k);
                }
                
                list.add(temp);
                i=k;
            }
        }
        return list;
    }
}
