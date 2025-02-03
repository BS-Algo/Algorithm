N, M = map(int, input().split())
A = []
for _ in range(N):
    A.append(int(input()))

B = sorted(A)

for _ in range(M):
    D = int(input())

    start = 0
    end = N - 1
    idx = N

    while start <= end:
        mid = (start + end) // 2

        if B[mid] < D:
            start = mid + 1
        elif B[mid] == D:
            idx = min(idx, mid)
            end = mid - 1
        else:
            end = mid - 1

    if idx < N:
        print(idx)
    elif idx == N:
        print(-1)