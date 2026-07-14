// Last updated: 14/07/2026, 16:13:19
import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreStack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                int top = scoreStack.pop();
                int newScore = top + scoreStack.peek();
                scoreStack.push(top);
                scoreStack.push(newScore);
            } else if (op.equals("D")) {
                scoreStack.push(scoreStack.peek() * 2);
            } else if (op.equals("C")) {
               
                scoreStack.pop();
            } else {
                scoreStack.push(Integer.parseInt(op));
            }
        }
        int totalSum = 0;
        for (int score : scoreStack) {
            totalSum += score;
        }
        
        return totalSum;
    }
}