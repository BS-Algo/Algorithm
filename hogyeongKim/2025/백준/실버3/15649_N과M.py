from itertools import permutations

N, M = map(int, input().split())
# num_lst = [i for i in range(1, N+1)]

# for i in range(1, N):
#     for j in range(1, M):
#         print(i, j)

# lst = list(permutations(num_lst, M))
# [print(*number) for number in lst]

path = []
def back(x):
    global N, M
    
    if len(path) == M:
        print(*path)
        return
        
    for i in range(1, N+1):
        if i not in path:
            path.append(i)
            back(x+1)
            path.pop()

back(0)