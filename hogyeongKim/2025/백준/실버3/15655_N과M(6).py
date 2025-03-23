from itertools import permutations
from collections import deque

N, M = map(int, input().split())

num_lst = list(map(int, input().split()))

# result = deque(list(permutations(num_lst, M)))
# for i in range(len(result)):
#     pmt = result.popleft()
#     pmt = list(pmt)
#     pmt.sort()
#     result.append(tuple(pmt))
    
# result = sorted(list(set(result)))

# for i in range(len(result)):
#     print(*result[i])

path = []
result = set()
visited = [False] * N
def back():
    global N, M
    
    if len(path) == M:
        tmp = tuple(sorted(path))
        result.add(tmp)
        return
            
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            path.append(num_lst[i])
            back()
            path.pop()
            visited[i] = False
        
back()
result = sorted(list(result))
for i in range(len(result)):
    print(*result[i])