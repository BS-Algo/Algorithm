from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    queue = deque()
    queue.append(start)

    visited = [0] * (n + 1)
    visited[start] = 1
    cnt = 0

    while queue:
        x = queue.popleft()
        for i in comp[x]:
            if not visited[i]:
                visited[i] = 1
                queue.append(i)
                cnt += 1

    return cnt

n, m = map(int, input().split())
comp = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    comp[b].append(a)

result = []
for i in range(1, n+1):
    result.append(bfs(i))

for i in range(len(result)):
    if result[i] == max(result):
        print(i+1, end=' ')