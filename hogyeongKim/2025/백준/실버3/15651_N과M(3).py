from itertools import product

N, M = map(int, input().split())
num_lst = [i for i in range(1, N+1)]

lst = list(product(num_lst, repeat=M))
lst.sort()
[print(*number) for number in lst]

# path = []
# result = []
# def back(idx):
#     global N, M
    
#     if len(path) == M:
#         tmp = tuple(path)
#         result.append(tmp)
#         return
        
#     for i in range(N):
#         path.append(num_lst[i])
#         back(idx+1)
#         path.pop()

# back(0)
# result.sort()

# for i in range(len(result)):
#     print(*result[i])