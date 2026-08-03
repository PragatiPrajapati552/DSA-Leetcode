class Solution {
    static long mod = 1000000007;
    public int countGoodNumbers(long n) {
    long even = (n+1) / 2;
    long odd = n / 2;
    
     long ans  = (pow(5, even) * pow(4, odd))% mod;
     return (int)ans;
    }
    public static long pow(int x, long n){
        if(n == 0)
        return 1;

        long ans = pow(x,n/2);
        ans = (ans*ans) % mod;

        if(n%2!=0)
        ans = (x*ans) % mod;

        return ans;

    }
}