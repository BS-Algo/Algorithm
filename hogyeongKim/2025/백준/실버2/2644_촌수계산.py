import sys
input = sys.stdin.readline

n = int(input())
p1, p2 = map(int, input().split())
graphs = [[] for _ in range(n+1)]
m = int(input())

for _ in range(m):
    a, b = map(int, input().split())
    graphs[a].append(b)
    graphs[b].append(a)

visited = [False] * (n+1)
cnt = -1

def dfs(node, x):
    global p2, cnt
    
    if visited[p2]:
        cnt = x
        return
    
    for next_node in graphs[node]:
        if not visited[next_node]:
            visited[next_node] = True
            if dfs(next_node, x + 1):
                return
            visited[next_node] = False
    return

visited[p1] = True
dfs(p1, 0)
print(cnt)