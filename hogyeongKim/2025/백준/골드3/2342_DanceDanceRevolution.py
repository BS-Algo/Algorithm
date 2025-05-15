steps = list(map(int, input().split()))

def calculate_costs(cur, next):
    # 현재 좌표가 0인 경우
    if cur == 0:
        return 2
    # 현재 좌표와 다음 좌표가 같은 경우, 현재 발로 밟을 수 있음. 반대 발은 '두 발이 같은 좌표에 존재할 수 없다'는 규칙 때문에 움직일 수 없음.
    elif cur == next:
        return 1
    # 뺏을 때 절댓값이 2인 경우 반대편으로 이동
    elif abs(cur-next) == 2:
        return 4
    # 그 외에는 인접한 곳으로 이동
    else:
        return 3

dp = [[float('inf')] * 5 for _ in range(5)]
dp[0][0] = 0
    
for next_pos in steps:
    if next_pos == 0:
        break
    
    # 각 스텝마다 이전의 dp를 가져와서 계산해야 하므로 new_dp를 생성
    new_dp = [[float('inf')] * 5 for _ in range(5)]
    
    # 모든 좌표에서 next 좌표로 이동할 때 가능한 비용들을 계산해서 new_dp에 저장
    for left in range(5):
        for right in range(5):
            # 시작좌표가 아니면 생략
            if dp[left][right] == float('inf'):
                continue
            
            # 왼발 이동
            new_dp[next_pos][right] = min(new_dp[next_pos][right], dp[left][right] + calculate_costs(left, next_pos))
            
            # 오른발 이동
            new_dp[left][next_pos] = min(new_dp[left][next_pos], dp[left][right] + calculate_costs(right, next_pos))

    dp = new_dp
# 최솟값 찾기
min_cost = min(map(min, dp))
print(min_cost)