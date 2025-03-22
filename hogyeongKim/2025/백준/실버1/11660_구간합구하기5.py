N, M = map(int, input().split())

num_lst = [list(map(int, input().split())) for _ in range(N)]

coor_lst = [list(map(int, input().split())) for _ in range(M)]

prefix = [[0] * (N +  1) for _ in range(N + 1)]

for x in range(N):
    for y in range(N):
        prefix[x+1][y+1] = prefix[x+1][y] + prefix[x][y+1] - prefix[x][y] + num_lst[x][y]
        
for coor in coor_lst:
    x1, y1, x2, y2 = coor
    print(prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1])

# N, M = map(int, input().split())

# num_lst = [list(map(int, input().split())) for _ in range(N)]

# coor_lst = [list(map(int, input().split())) for _ in range(M)]

# # 첫 번째 행의 누적합
# for y in range(1, N):
#     num_lst[0][y] += num_lst[0][y-1]
    
# # 첫 번째 열의 누적합
# for x in range(1, N):
#     num_lst[x][0] += num_lst[x-1][0]
    
# # 나머지 부분의 누적합
# for y in range(1, N):
#     for x in range(1, N):
#         num_lst[x][y] = num_lst[x][y-1] + num_lst[x-1][y] - num_lst[x-1][y-1] + num_lst[x][y]