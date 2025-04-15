import sys
input = sys.stdin.readline

n = int(input())
sheet = list(map(int, input().split()))

tc = int(input())

sm = [0] * (n+1)
tmp = 0
for i in range(n-1):
    if sheet[i] > sheet[i+1]:
        tmp += 1
    sm[i+1] = tmp
sm[-1] = tmp

for _ in range(tc):
    s, e = map(int, input().split())
    print(sm[e-1] - sm[s-1])