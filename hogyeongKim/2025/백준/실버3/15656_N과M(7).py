from itertools import product
from collections import deque

N, M = map(int, input().split())

num_lst = list(map(int, input().split()))

result = deque(list(product(num_lst, repeat=M)))
    
result = sorted(list(set(result)))

for i in range(len(result)):
    print(*result[i])

# path = []
# result = set()
# def back():
#     global N, M
    
#     if len(path) == M:
#         tmp = tuple(path)
#         result.add(tmp)
#         return
            
#     for i in range(N):
#         path.append(num_lst[i])
#         back()
#         path.pop()
        
# back()
# result = sorted(result)
# for i in range(len(result)):
#     print(*result[i])