def dfs(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return
    
    prev = -1
    for i in range(N):
        if not visited[i] and prev != arr[i]:
            visited[i] = True
            result.append(arr[i])
            prev = arr[i]
            dfs(depth+1)
            result.pop()
            visited[i] = False



N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

result = []
visited = [False] * (N)

dfs(0)

