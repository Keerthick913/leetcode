// Last updated: 14/07/2026, 16:17:25
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the candidates to handle duplicates easily
        Arrays.sort(candidates);
        // Start backtracking from index 0
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // Exceeded the target sum
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                // Skip duplicate elements at the same decision level
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                
                // Optimization: if the current number is greater than the remaining target, 
                // all subsequent numbers will also be greater (since the array is sorted)
                if (candidates[i] > remain) {
                    break;
                }

                // Make the choice
                tempList.add(candidates[i]);
                
                // Recurse with i + 1 because each element can only be used once
                backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
                
                // Undo the choice (backtrack)
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}