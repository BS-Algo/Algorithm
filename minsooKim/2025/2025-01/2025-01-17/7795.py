T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    A.sort()
    B = list(map(int, input().split()))
    B.sort()
    cnt = 0

    for a in A:
        start = 0
        end = len(B) - 1

        while start <= end:
            mid = (start + end) // 2
            if B[mid] < a: # A[i] > B[mid] A의 원소가 B보다 크다면
                start = mid + 1
            else:
                end = mid -1
        cnt += start

    print(cnt)
        # 어떨때 end = mid -1 start = mid + 1이 되야하는가,,,
    # for i in range(N):
    #     for j in range(M):
    #         if A[i] > B[j] :
    #             cnt += 1
    # print(cnt)
# 시간초과 왜냐면 A[i]랑 B[j]를 일일히 돌면서 다 찾아야하니까.
# 그럼 이분탐색으로 어떻게 시간을 줄여야하나?
# 뭘 start 뭘 end?