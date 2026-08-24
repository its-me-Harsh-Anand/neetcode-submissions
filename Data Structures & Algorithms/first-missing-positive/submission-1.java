class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int el : nums){
            if(el>0) set.add(el);
        }

        int i = 1;
        int size = set.size();
        while(i<=size){
            if(set.contains(i) == false){
                return i;
            }
            i++;
        }
        return i;
    }
}