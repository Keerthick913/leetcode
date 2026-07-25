# Last updated: 25/07/2026, 13:38:00
1class Solution:
2    def fullJustify(self, words: list[str], maxWidth: int) -> list[str]:
3        res = []
4        cur_line = []
5        num_of_letters = 0
6
7        for word in words:
8            if num_of_letters + len(word) + len(cur_line) > maxWidth:
9                for i in range(maxWidth - num_of_letters):
10                    cur_line[i % (len(cur_line) - 1 or 1)] += ' '
11                res.append(''.join(cur_line))
12                cur_line, num_of_letters = [], 0
13            cur_line.append(word)
14            num_of_letters += len(word)
15        res.append(' '.join(cur_line).ljust(maxWidth))
16        return res