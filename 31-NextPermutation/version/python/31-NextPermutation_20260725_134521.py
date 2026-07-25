# Last updated: 25/07/2026, 13:45:21
1class Solution:
2    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
3        if not matrix or not matrix[0]:
4            return False
5        m, n = len(matrix), len(matrix[0])
6        low, high = 0, m * n - 1
7        while low <= high:
8            mid = (low + high) // 2
9            row, col = mid // n, mid % n
10            val = matrix[row][col]
11            if val == target:
12                return True
13            elif val < target:
14                low = mid + 1
15            else:
16                high = mid - 1
17        return False