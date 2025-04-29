import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 정점 수 n, 루트 번호 r, 쿼리 수 q
n, r, q = map(int, input().split())
graphs = [[] for _ in range(n+1)]
sub_cnt = [0] * (n+1)

for _ in range(n-1):
    a, b = map(int, input().split())
    graphs[a].append(b)
    graphs[b].append(a)
    
u_nodes = [int(input()) for _ in range(q)]

def find_subtree(node, parent):
    sub_cnt[node] = 1
    
    for next_node in graphs[node]:
        if next_node != parent:
            find_subtree(next_node, node)
            sub_cnt[node] += sub_cnt[next_node]
            
find_subtree(r, -1)
for u in u_nodes:
    print(sub_cnt[u])