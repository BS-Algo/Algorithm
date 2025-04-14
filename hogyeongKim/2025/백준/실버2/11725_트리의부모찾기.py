import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())

# 연결 정보 저장할 리스트
graph = [[] for _ in range(n+1)]

# 각 자식노드의 부모 노드 정보를 저장할 리스트
parents = [0] * (n+1)

# 사이클이 없기 때문에 단순 DFS로도 찾기 쉬움
def dfs(node):
    # 그래프 리스트에서 하나씩 가져와서 만약 이 노드가 부모가 없으면, node 값을 부모로 가진다.
    for child in graph[node]:
        if not parents[child]:
            parents[child] = node
            dfs(child)
        
    
# 간선 정보 저장하는 것이기 때문에 (그래프의 개수 - 1)
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 1번 노드가 자기자신을 자식으로 삼는 경우 무한 루프가 발생하므로 방지
parents[1] = -1
dfs(1)

# 자식노드 i가 어떤 부모 노드를 가지고 있는지 출력
for i in range(2, n+1):
    print(parents[i])
