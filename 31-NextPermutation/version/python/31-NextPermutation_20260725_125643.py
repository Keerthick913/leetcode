# Last updated: 25/07/2026, 12:56:43
1class Solution:
2    def permute(self, nums: List[int]) -> List[List[int]]:
3        ans = []
4        perm = []
5        pick = [False]*len(nums)
6        
7        def backtrack():
8            if len(perm) == len(nums):
9                ans.append(perm.copy())
10                return 
11            
12            for i in range(len(nums)):
13                if not pick[i]:
14                    perm.append(nums[i])
15                    pick[i] = True
16                    backtrack()
17                    perm.pop()
18                    pick[i] = False
19        backtrack()
20        
21        return ans
22
23  