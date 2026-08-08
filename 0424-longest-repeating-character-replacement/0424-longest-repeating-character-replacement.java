class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        int maxFreq = 0;
        for(int j = 0; j<s.length(); j++){
            char ch = s.charAt(j);
             map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(map.get(ch) , maxFreq);
            while((j-i+1) - maxFreq > k){
                map.put(s.charAt(i) , map.get(s.charAt(i))-1 );
                if(map.get(s.charAt(i))== 0)
                map.remove(s.charAt(i));
                i++;    
            }
            max = Math.max(max, (j-i+1));

        }
        return max;
    }
}