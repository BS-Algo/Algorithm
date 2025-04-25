N = int(input())
M = int(input())
arr = list(map(int, input().split()))
cnt = 0
for i in range(N-1):
    for j in range(i+1, N):
        if arr[i] + arr[j] == M:
            cnt += 1
            break
print(cnt)
