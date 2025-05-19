import sys
input = sys.stdin.readline

n, m = map(int, input().split())
parents = [i for i in range(n)]
cycle_check = 0

def find_parents(x):
    while x != parents[x]:
        parents[x] = parents[parents[x]]
        x = parents[x]
    return x


def union_find(x, y):
    a = find_parents(x)
    b = find_parents(y)
    
    if a != b:
        parents[a] = b
        return False
    return True

for i in range(m):
    a, b = map(int, input().split())
    if union_find(a, b):
        cycle_check = i + 1
        break

print(cycle_check)