import sys
input = sys.stdin.readline

n = int(input())

num_lst = [[0]] + [list(map(int, input().split())) for _ in range(n)]
for i in range(n-1, 0, -1):
    for j in range(i):
        num_lst[i][j] += max(num_lst[i+1][j], num_lst[i+1][j+1])

print(num_lst[1][0])