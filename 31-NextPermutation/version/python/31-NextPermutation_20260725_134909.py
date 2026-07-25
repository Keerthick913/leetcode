# Last updated: 25/07/2026, 13:49:09
1class Solution:
2    def subsets(self, nums: list[int]) -> list[list[int]]:
3        res = []
4        def backtrack(index: int, path: list[int]):
5            res.append(path.copy())
6            for i in range(index, len(nums)):
7                path.append(nums[i])
8                backtrack(i + 1, path)
9                path.pop() 
10        backtrack(0, [])
11        return res  