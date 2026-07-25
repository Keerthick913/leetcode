# Last updated: 25/07/2026, 13:46:46
1class Solution:
2    def combine(self, n: int, k: int) -> list[list[int]]:
3        res = []
4        def backtrack(start: int, path: list[int]):
5            if len(path) == k:
6                res.append(path.copy())
7                return
8            need = k - len(path)
9            for i in range(start, n - need + 2):
10                path.append(i)
11                backtrack(i + 1, path)
12                path.pop()  
13        backtrack(1, [])
14        return res