// Last updated: 18/09/2026, 09:22:34
1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public boolean isRectangleCover(int[][] rectangles) {
6        int minX = Integer.MAX_VALUE;
7        int minY = Integer.MAX_VALUE;
8        int maxX = Integer.MIN_VALUE;
9        int maxY = Integer.MIN_VALUE;
10
11        long totalArea = 0;
12        Set<String> set = new HashSet<>();
13
14        for (int[] rect : rectangles) {
15            minX = Math.min(minX, rect[0]);
16            minY = Math.min(minY, rect[1]);
17            maxX = Math.max(maxX, rect[2]);
18            maxY = Math.max(maxY, rect[3]);
19
20            totalArea += (long) (rect[2] - rect[0]) * (rect[3] - rect[1]);
21
22            // Define four corners of the current sub-rectangle
23            String p1 = rect[0] + "," + rect[1];
24            String p2 = rect[0] + "," + rect[3];
25            String p3 = rect[2] + "," + rect[1];
26            String p4 = rect[2] + "," + rect[3];
27
28            // Toggle points in set
29            if (!set.add(p1)) set.remove(p1);
30            if (!set.add(p2)) set.remove(p2);
31            if (!set.add(p3)) set.remove(p3);
32            if (!set.add(p4)) set.remove(p4);
33        }
34
35        // Check if global area matches total sub-rectangle area
36        long expectedArea = (long) (maxX - minX) * (maxY - minY);
37        if (totalArea != expectedArea) return false;
38
39        // Check if set contains exactly the 4 global corners
40        if (set.size() != 4 || 
41            !set.contains(minX + "," + minY) || 
42            !set.contains(minX + "," + maxY) || 
43            !set.contains(maxX + "," + minY) || 
44            !set.contains(maxX + "," + maxY)) {
45            return false;
46        }
47
48        return true;
49    }
50}