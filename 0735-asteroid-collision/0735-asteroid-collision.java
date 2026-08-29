// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         Stack<Integer> s = new Stack<>();
//         ArrayList<Integer> ans = new ArrayList<>();
//         for(int i = 0;i<asteroids.length;i++){
//             if(!s.isEmpty() && s.peek()<0){
//                 s.push(asteroids[i]);
//                 continue;
//             }
            
//             while(!s.isEmpty() && s.peek()>0 && asteroids[i] < 0 && Math.abs(s.peek()) <= Math.abs(asteroids[i])){
//                 if(!s.isEmpty()&&s.peek() == -asteroids[i]){
//                 s.pop();
//                 break;
//             }
//                 s.pop();
//             }
//             if(s.isEmpty() || (s.peek() > 0 && asteroids[i]>0) || (s.peek() < 0 && asteroids[i]>0)|| (s.peek() < 0 && asteroids[i]<0))
//             s.push(asteroids[i]);
//         }
//         while(!s.isEmpty()){
//             ans.add(s.pop());
//         }
//         int[] arr = new int[ans.size()];
//         int j = 0;
//         for (int i = ans.size()-1; i >=0; i--) {
//             arr[j] = ans.get(i);
//             j++;
//         }
//         return arr;
//     }
// }
import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision is possible only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                // Same size -> both explode
                if (stack.peek() == -asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Stack asteroid is bigger -> current explodes
                else if (stack.peek() > -asteroid) {
                    destroyed = true;
                    break;
                }

                // Current asteroid is bigger -> stack asteroid explodes
                else {
                    stack.pop();
                }
            }

            // Push only if current asteroid survived
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}