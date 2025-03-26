from itertools import permutations

N, M = map(int, input().split())
num_lst = [i for i in range(1, N+1)]

lst = list(permutations(num_lst, M))

for i in range(len(lst)):
    lst[i] = tuple(sorted(lst[i]))

lst = sorted(list(set(lst)))

[print(*number) for number in lst]

# path = []
# visited = [False] * N
# result = set()
# def back(x):
#     global N, M
    
#     if len(path) == M:
#         tmp = sorted(list(path))
#         result.add(tuple(tmp))
#         return
        
#     for i in range(N):
#         if not visited[i]:
#             visited[i] = True
#             path.append(num_lst[i])
#             back(x+1)
#             path.pop()
#             visited[i] = False

# back(0)
# result = sorted(list(result))
# for i in range(len(result)):
#     print(*result[i])