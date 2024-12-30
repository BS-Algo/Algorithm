M, N, K = map(int, input().split())
graph = [[0] * N for _ in range(M)]
graph[0][1] = 1
# for a in range(K):
#     start_x, start_y, end_x, end_y = map(int, input().split())
#     # 0 2 4 4
#     new_s_x = start_x
#     # 0
#     new_s_y = M - end_y
#     # 1
#     new_e_x = end_x -1
#     # 3
#     new_e_y = M - (start_y + 1)
#     # 2
#     for i in range(new_s_x, new_e_x + 1):
#         # i = 0, 1, 2, 3
#         for j in range(new_s_y, new_e_y + 1):
#             # j = 1, 2
#             graph[i][j] = 1
print(graph)

