import sys
input = sys.stdin.readline

# 좌표가 연속적으로 주어지므로 신발끈 공식을 이용해서 풀 것.
n = int(input())
coordinates = [list(map(int, input().split())) for _ in range(n)]

result = 0
for i in range(1, n):
    result += coordinates[i-1][0]*coordinates[i][1] - coordinates[i][0]*coordinates[i-1][1]

result += coordinates[n-1][0]*coordinates[0][1] - coordinates[0][0]*coordinates[n-1][1]
print(abs(result)/2)