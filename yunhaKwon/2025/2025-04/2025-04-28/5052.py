import sys
input=sys.stdin.readline
T = int(input())
for _ in range(T):
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(str(input().rstrip()))
    arr.sort()
    cnt = 0
    for i in range(1, N):
        if arr[i-1] == arr[i][:len(arr[i-1])]:
            cnt += 1
            break

    if cnt > 0:
        print("NO")
    else:
        print("YES")