N, K = map(int, input().split())
level = list(int(input()) for _ in range(N))

start = min(level) #최소 레벨
end = min(level) + K #최소 레벨에서 K만큼 올릴 수 있음
ans = 0 #가능한 최대 목표 레벨(최종 정답)

while start <= end:
    mid = (start + end) // 2 #목표 레벨 후보

    cnt = 0 #목표 레벨까지 올리는데 필요한 총합
    for l in level:
        if mid > l:
            cnt += (mid - l) #현재 레벨이 목표 레벨보다 작으면 부족한 만큼 cnt에 더함

    if cnt <= K: #필요한 총합이 K 이하면 목표 레벨 더 높일 수 있음
        start = mid + 1
        ans = max(ans, mid) #목표 레벨 후보를 계속해서 최댓값으로 갱신
    else:
        end = mid - 1 #필요한 총합이 K 초과면 목표 레벨 낮춰야 됨

print(ans) #가능한 목표 레벨의 최댓값