# Last updated: 25/07/2026, 13:25:58
1class Solution:
2    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
3        top = 0
4        bottom = len(matrix) - 1
5        left = 0
6        right = len(matrix[0]) - 1
7        spiral = []
8        while top <= bottom and left <= right:
9            for i in range(left, right + 1):
10                spiral.append(matrix[top][i])
11            top += 1
12            for j in range(top, bottom + 1):
13                spiral.append(matrix[j][right])
14            right -= 1
15            if top <= bottom:
16                for k in range(right, left - 1, -1):
17                    spiral.append(matrix[bottom][k])
18                bottom -= 1
19            if left <= right:
20                for l in range(bottom, top - 1, -1):
21                    spiral.append(matrix[l][left])
22                left += 1
23        return spiral    