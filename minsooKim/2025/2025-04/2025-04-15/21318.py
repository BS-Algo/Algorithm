N = int(input())
arr = list(map(int, input().split()))
lst = [0] * (N+1)
cnt = 0
for i in range(N-1):
    if arr[i] > arr[i+1]:
        cnt += 1
    lst[i+1] = cnt
lst[-1] = cnt
print(lst)

Q = int(input())
for _ in range(Q):
    x, y = map(int, input().split())
    print(lst[y-1] - lst[x-1])
