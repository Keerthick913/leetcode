# Last updated: 25/07/2026, 12:53:11
1class Solution:
2    def jump(self, nums: List[int]) -> int:
3        near = far = jumps = 0
4        while far < len(nums) - 1:
5            farthest = 0
6            for i in range(near, far + 1):
7                farthest = max(farthest, i + nums[i])
8            near = far + 1
9            far = farthest
10            jumps += 1
11        return jumps    