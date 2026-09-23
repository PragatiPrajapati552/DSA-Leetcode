class Solution {

    public static void indeg(int[][] prerequisites, int in[]){
        for(int i=0; i<prerequisites.length;i++){
            int ind = prerequisites[i][0];
            in[ind] ++;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indeg[] = new int[numCourses];
        indeg(prerequisites, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses ;i++)
        if(indeg[i] == 0)
        q.add(i);

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == curr)
                {
                    indeg[prerequisites[i][0]]--;

                    if(indeg[prerequisites[i][0]] == 0)
                    q.add(prerequisites[i][0]);
                }
            }
        }

        if(ans.size() != numCourses)
        return new int[0];

       int[] an = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            an[i] = ans.get(i);
        }   

        return an;
    }
}