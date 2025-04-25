N = int(input())
M = int(input())
arr = list(map(int, input().split()))
l = len(arr)
cnt = 0

for i in range(0, l-1):
    for j in range(i+1, l):
        result = arr[i] + arr[j]
        if result != M:
            continue
        cnt += 1

print(cnt)