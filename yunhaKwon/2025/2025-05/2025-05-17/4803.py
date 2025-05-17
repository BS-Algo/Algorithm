def dfs(tree, node, visited, parent):
    visited[node] = 1
    for x in tree[node]:
        if visited[x] == 0:
            if not dfs(tree, x, visited, node):
                return False
        elif x != parent:
            return False
    return True

cnt = 1
while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    tree = [[] for _ in range(n + 1)]
    visited = [0] * (n + 1)
    tree_count = 0

    for _ in range(m):
        a, b = map(int, input().split())
        tree[a].append(b)
        tree[b].append(a)

    for i in range(1, n + 1):
        if visited[i] == 0:
            if dfs(tree, i, visited, 0):
                tree_count += 1  # 사이클 없는 연결 요소만 카운트

    if tree_count == 0:
        print(f'Case {cnt}: No trees.')
    elif tree_count == 1:
        print(f'Case {cnt}: There is one tree.')
    else:
        print(f'Case {cnt}: A forest of {tree_count} trees.')

    cnt += 1
