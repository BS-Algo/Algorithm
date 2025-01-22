N, M = map(int, input().split())
arr = []
for _ in range(N):
    name, num = input().split()
    num = int(num)
    arr.append((name, num))

for i in range(M):
    power = int(input())

    start = 0
    end = N - 1

    while start <= end:
        mid = (start + end) // 2 # mid = 1
        if power > arr[mid][1]: # 50000 >= 100000
            start = mid + 1
        else:
            result = mid
            end = mid - 1
    print(arr[start][0])