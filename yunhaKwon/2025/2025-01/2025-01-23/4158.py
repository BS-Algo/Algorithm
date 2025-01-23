while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0:
        break

    a_arr = []
    b_arr = []
    for _ in range(N):
        a_arr.append(int(input()))
    for _ in range(M):
        b_arr.append((int(input())))

    cnt = 0
    for i in range(N):
        start = 0
        end = M - 1

        while start <= end:
            mid = (start + end) // 2

            if b_arr[mid] == a_arr[i]:
                cnt += 1
                break
            elif b_arr[mid] < a_arr[i]:
                start = mid + 1
            elif b_arr[mid] > a_arr[i]:
                end = mid - 1

    print(cnt)