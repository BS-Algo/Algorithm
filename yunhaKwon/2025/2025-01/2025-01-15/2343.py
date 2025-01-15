N, M = map(int, input().split())
arr = list(map(int, input().split()))

start = max(arr) # 블루레이 크기 최소값
end = sum(arr) # 블루레이 크기 최대값

while start <= end:
    mid = (start + end) // 2

    total = 0 # 현재 블루레이에 담긴 강의 길이 합
    cnt = 1 # 블루레이 개수 (최소 1개 이상)

    for i in arr:
        if total + i > mid: # 현재 블루레이에 더 담을 수 없다면
            cnt += 1 # 새로운 블루레이 추가
            total = 0 # 블루레이 값 초기화

        total += i # 현재 블루레이에 강의 추가

    if cnt <= M: # 블루레이 개수가 M 이하로 가능하다면
        ans = mid # 현재 블루레이 크기를 후보로 저장
        end = mid - 1 # 더 작은 블루레이 크기 시도
    else: # 블루레이 개수가 M개보다 많다면
        start = mid + 1 # 더 큰 블루레이 크기 시도

print(ans)
