N = int(input())
M = int(input())
x = list(map(int, input().split()))

start = 1
end = N
result = 0

while start <= end:
    mid = (start + end) // 2
    # 이전 위치를 기록할 변수
    prev_position = 0
    is_valid = True

    for pos in x:
        # 현재 가로등이 커버해야 할 거리 계산
        if pos - prev_position > mid:
            is_valid = False
            break
        # 가로등 범위 끝 갱신
        prev_position = pos + mid

    # 마지막 위치 이후로도 커버가 되는지 확인
    if N - prev_position > 0:
        is_valid = False

    if is_valid:
        result = mid
        end = mid - 1
    else:
        start = mid + 1

print(result)
