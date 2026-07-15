// Last updated: 15/07/2026, 14:42:40
1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        int n = heights.length;
4        if(n == 0) return 0; 
5        int maxArea = 0;
6        int left[] = new int[n]; 
7        int right[] = new int[n]; 
8        
9        left[0] = -1;
10        right[n - 1] = n;
11        
12        for(int i = 1; i < n; i++){
13            int prev = i - 1; 
14            while(prev >= 0 && heights[prev] >= heights[i]){
15                prev = left[prev]; 
16            }
17            left[i] = prev;
18        }
19        for(int i = n - 2; i >= 0; i--){
20            int prev = i + 1; 
21            while(prev < n && heights[prev] >= heights[i]){
22                prev = right[prev]; 
23            }
24            right[i] = prev;
25        }
26        for(int i = 0; i < n; i++){
27            int width = right[i] - left[i] - 1;
28            maxArea = Math.max(maxArea, heights[i] * width);
29        }
30        return maxArea;
31        
32    }
33}