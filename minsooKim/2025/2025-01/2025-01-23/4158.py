while True:
    N, M = map(int, input().split())
    if N == M == 0:
        break
    n_arr = []
    m_arr = []
    for _ in range(N):
        n_arr.append(int(input()))
    for _ in range(M):
        m_arr.append(int(input()))
    
    cnt = 0
    
    for i in n_arr:
        start = 0
        end = M - 1
        while start <= end:
            mid = (start + end) // 2

            if i == m_arr[mid]:
                cnt += 1
                break
            elif i < m_arr[mid]:
                end = mid - 1
            elif i > m_arr[mid]:
                start = mid + 1
    print(cnt)
