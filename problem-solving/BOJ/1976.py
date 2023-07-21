import sys

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    rootx = find(x)
    rooty = find(y)
    if rootx != rooty:
        parent[rooty] = rootx

input = sys.stdin.readline

n = int(input().strip())
m = int(input().strip())

parent = list(range(n))
cities = set()

for i in range(n):
    data = list(map(int, input().split()))
    for j in range(n):
        if data[j] == 1:
            union(i, j)

plan = list(map(int, input().split()))
plan = [x-1 for x in plan]

root = find(plan[0])
res = 'YES'

for city in plan:
    if find(city) != root:
        res = 'NO'
print(res)