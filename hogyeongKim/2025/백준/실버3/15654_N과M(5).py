from itertools import permutations

N, M = map(int, input().split())

num_lst = list(map(int, input().split()))

# result = list(permutations(num_lst, M))
# result.sort()

# for i in range(len(result)):
#     print(*result[i])

path = []
result = []
visited = [False] * N
def back():
    global N, M
    
    if len(path) == M:
        result.append(tuple(path))
        return
            
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            path.append(num_lst[i])
            back()
            path.pop()
            visited[i] = False
        
back()
result.sort()
for i in range(len(result)):
    print(*result[i])