import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        long MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s = new Stack<>();

        // Previous strictly smaller element
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }

            left[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }

        s.clear();

        // Next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            right[i] = s.isEmpty() ? n - i : s.peek() - i;
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) sum;
    }
}