import sys
from collections import defaultdict

input = sys.stdin.readline

n, k = map(int, input().split())
l = list(map(int, input().split()))

left = 0
right = 0
counts = defaultdict(int)
res = 0

while right < n:
    counts[l[right]] += 1
    while counts[l[right]] > k:
        counts[l[left]] -= 1
        left += 1
    res = max(res, right - left + 1)
    right += 1

print(res)




