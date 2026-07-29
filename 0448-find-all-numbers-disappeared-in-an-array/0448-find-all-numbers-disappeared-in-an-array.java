import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet <Integer> map = new HashSet<>();
        // int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            // max = Math.max(max,nums[i]);
            if(!map.contains(nums[i])){
                map.add(nums[i]);
            }
        }
        for(int i =1;i<=nums.length;i++){
            if(!map.contains(i))
            list.add(i);
        }
        return list;
    }
}