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
        # 1234 31234
        # 1234 == arr[i
        if arr[i-1] in arr[i]:
            cnt += 1
            break

    if cnt > 0:
        print("NO")
    else:
        print("YES")