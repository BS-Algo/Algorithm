import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(node, pos):
    visited[node] = pos
    for next_node in graphs[node]:
        if not visited[next_node]:
            if not dfs(next_node, -pos):
                return False
        elif visited[next_node] == pos:
            return False
    return True

for _ in range(int(input())):
    v, e = map(int, input().split())
    graphs = [[] for _ in range(v+1)]

    for _ in range(e):
        a, b = map(int, input().split())
        graphs[a].append(b)
        graphs[b].append(a)
  
    checker = True
    visited = [0] * (v+1)
    for i in range(v+1):
        if not visited[i]:
            if not dfs(i, 1):
                checker = False
                break
    print('YES' if checker else 'NO')