import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> main = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();     //it shows that we are using arraylist from List interface

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    list.add(main.get(i - 1).get(j - 1) + main.get(i - 1).get(j));
            }

            main.add(list);
        }

        return main;
    }
}