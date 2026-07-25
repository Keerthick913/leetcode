# Last updated: 25/07/2026, 13:28:15
1class Solution:
2    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
3        merged = []
4        i = 0
5        while i < len(intervals) and intervals[i][1] < newInterval[0]:
6            merged.append(intervals[i])
7            i += 1
8        while i < len(intervals) and intervals[i][0] <= newInterval[1]:
9            newInterval = [min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]
10            i += 1
11        merged.append(newInterval)
12        while i < len(intervals):
13            merged.append(intervals[i])
14            i += 1
15        return merged   