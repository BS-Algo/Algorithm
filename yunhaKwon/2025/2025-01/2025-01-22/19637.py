import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = []
for _ in range(N):
    tier, maximum = map(str, input().split())
    arr.append([tier, int(maximum)])

for _ in range(M):
    power = int(input())

    start, end = 0, N - 1
    while start <= end:
        mid = (start + end) // 2
        if power > arr[mid][1]:
            start = mid + 1
        else:
            end = mid - 1

    print(arr[start][0])