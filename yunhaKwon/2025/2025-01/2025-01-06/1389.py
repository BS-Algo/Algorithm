from collections import deque

def bfs(start):
   kevin_lst = [0] * (n+1) #x 기준 케빈 베이컨 수 리스트
   visited[start] = 1
   queue = deque()
   queue.append(start)

   while queue:
       v = queue.popleft()
       for i in graph[v]:
           if not visited[i]:
               kevin_lst[i] = kevin_lst[v] + 1
               visited[i] = 1
               queue.append(i)

   return sum(kevin_lst)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

result = []
for i in range(1, n+1):
    visited = [0] * (n+1)
    result.append(bfs(i))

print(result.index(min(result)) + 1)