N = int(input())
S = list(map(int, input().split()))
T, P = map(int, input().split())
cnt = 0
for i in S:
    if i % T == 0:
        cnt += (i // T)
    else:
        cnt += (i // T) + 1
print(cnt)
print(N // P, N % P)