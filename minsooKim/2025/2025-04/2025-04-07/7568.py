N = int(input())
arr = []
for _ in range(N):
    x, y = map(int, input().split())
    arr.append([x, y, 1])
for i in range(N-1):
    for j in range(i, N):
        if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
            arr[i][2] += 1
        elif arr[i][0] > arr[j][0] and arr[i][1] > arr[j][1]:
            arr[j][2] += 1
answer = []
for i in range(N):
    answer.append(arr[i][2])
print(*answer)
