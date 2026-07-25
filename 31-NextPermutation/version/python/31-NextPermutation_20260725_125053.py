# Last updated: 25/07/2026, 12:50:53
1class Solution(object):
2    def multiply(self, num1, num2):
3        n, m = len(num1), len(num2)
4        result = [0] * (n + m)
5        for i in range(n - 1, -1, -1):
6            for j in range(m - 1, -1, -1):
7                mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
8                sum_ = mul + result[i + j + 1]
9                result[i + j + 1] = sum_ % 10
10                result[i + j] += sum_ // 10
11        product = ''.join(map(str, result)).lstrip('0')
12        return product if product else "0"     