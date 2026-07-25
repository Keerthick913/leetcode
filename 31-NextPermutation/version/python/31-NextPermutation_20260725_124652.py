# Last updated: 25/07/2026, 12:46:52
1class Solution:
2    def backvers(self, nums, start, end):
3        while start < end:
4            nums[start], nums[end] = nums[end], nums[start]
5            start += 1
6            end -= 1
7
8    def nextPermutation(self, nums: list[int]) -> None:
9        idx = -1
10        length = len(nums)
11
12        for i in range(length - 2, -1, -1):
13            if nums[i] < nums[i + 1]:
14                idx = i
15                break
16
17        if idx == -1:
18            self.backvers(nums, 0, length - 1)
19            return
20
21        self.backvers(nums, idx + 1, length - 1)
22
23        newj = -1
24        for j in range(idx + 1, length):
25            if nums[idx] < nums[j]:
26                newj = j
27                break
28
29        nums[idx], nums[newj] = nums[newj], nums[idx]  