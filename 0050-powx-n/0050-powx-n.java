class Solution {
    public double myPow(double x, int n) {
        Long N = (long)n;
        if(N >=0)
        return help(x , N);
        else
        return 1/help(x, -1*N);

        
    }
    public double help(double x, long n){
        if(n == 0)
        return 1;
        
        double ans = help(x, n/2);
        if(n%2 == 0)
        return ans*ans;
        else
        return x* ans * ans;

    }
}