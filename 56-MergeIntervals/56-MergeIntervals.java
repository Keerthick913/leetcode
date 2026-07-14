// Last updated: 14/07/2026, 16:17:22
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedList = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            int currentEnd = currentInterval[1];
            int nextStart = nextInterval[0];
            int nextEnd = nextInterval[1];
            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}