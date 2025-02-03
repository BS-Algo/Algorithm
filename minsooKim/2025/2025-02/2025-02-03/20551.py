N, M = map(int, input().split())
arr = []
for _ in range(N):
    arr.append(int(input()))
arr.sort()
for _ in range(M):
    num = int(input())
    result = -1
    start = 0
    end = N - 1

    while start <= end:
        mid = (start + end) // 2 # mid는 arr의 인덱스값.
        # start = 0, end = 4 일 때, mid = 2
        # arr = [-1, 0, 2, 3, 9]
        # arr[mid] = 2
        # num = -1
        if arr[mid] >= num:
            if arr[mid] == num:
                result = mid
            end = mid - 1
        else:
            start = mid + 1
    print(result)
