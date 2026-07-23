import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        int appear = (int)Math.floor(nums.length/2.0);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
             map.put(nums[i], map.get(nums[i]) + 1);
            else
            map.put(nums[i],1);
        }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])> appear)
            return (nums[i]);
        }
        return -1;
    }
}