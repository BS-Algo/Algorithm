# 중복 조합, 백트래킹, itertools
from itertools import combinations_with_replacement

N, M = map(int, input().split())

num_lst = [i for i in range(1, N+1)]

# result = set(combinations_with_replacement(num_lst, M))

# result = sorted(list(result))

# for i in range(len(result)):
#     print(*result[i])

path = []
result = set()
def back(idx):
    global N, M
    
    if len(path) == M:
        tmp = path
        result.add(tuple(tmp))
        return
            
    for i in range(idx-1, N):
        path.append(num_lst[i])
        back(i + 1)
        path.pop()
        
back(1)
result = sorted(list(result))
for i in range(len(result)):
    print(*result[i])