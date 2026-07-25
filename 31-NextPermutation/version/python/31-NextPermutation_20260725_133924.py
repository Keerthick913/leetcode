# Last updated: 25/07/2026, 13:39:24
1class Solution:
2    def simplifyPath(self, path: str) -> str:
3        stack = []
4        for part in path.split("/"):
5            if part == "" or part == ".":
6                continue
7            elif part == "..":
8                if stack:
9                    stack.pop()
10            else:
11                stack.append(part)
12        return "/" + "/".join(stack)     