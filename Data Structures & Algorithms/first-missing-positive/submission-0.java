class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();

        for(int el : nums){
            if(el>0) set.add(el);
        }

        int i = 1;
        for(int el : set) {
            if(el != i) return i;
            i++;
        }
        return i;
    }
}