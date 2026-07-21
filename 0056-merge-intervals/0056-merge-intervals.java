import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<List<Integer>> arr = new ArrayList<>();
        int row = intervals.length;

        for(int i = 0; i < row; i++) {

            int k = i;
            int end = intervals[i][1];

            while(i < row - 1 && end >= intervals[i + 1][0]) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }

            arr.add(Arrays.asList(intervals[k][0], end));
        }

        int[][] ans = new int[arr.size()][2];

        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < 2; j++) {
                ans[i][j] = arr.get(i).get(j);
            }
        }

        return ans;
    }
}