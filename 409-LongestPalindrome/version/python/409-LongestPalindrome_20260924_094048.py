# Last updated: 24/09/2026, 09:40:48
1class Solution(object):
2    def fourSumCount(self, nums1, nums2, nums3, nums4):
3        from collections import Counter
4        d = Counter(a + b for a in nums1 for b in nums2)
5        return sum(d[-(c + d2)] for c in nums3 for d2 in nums4)
6        