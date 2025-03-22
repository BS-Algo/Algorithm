# 나는 개똥벌레~ 친구가 없네~

import sys
input = sys.stdin.readline

# 다이나믹 프로그래밍 (메모이제이션, 누적합)

N, H = map(int, input().split())

# top = 석순이 끝나는 곳, bottom = 종유석이 끝나는 곳(나중에 뒤집어서 사용)
top = [0] * (H + 1)
bottom = [0] * (H + 1)

# 홀수 = 석순(정방향), 짝수 = 종유석(역방향)

for i in range(N):
    height = int(input())
    
    # 석순
    if i % 2 == 0:
        bottom[height] += 1
    # 종유석
    else:
        top[height] += 1

# 석순과 종유석의 누적합을 계산. 개똥벌레는 0의 높이에서 날 수 없으므로 1 높이까지 계산.
for i in range(H-1, 0, -1):
    top[i] += top[i+1]
    bottom[i] += bottom[i+1]

# 종유석도 바닥에서 자라는 것처럼 계산을 해 왔으므로, 여기에서 역으로 뒤집어서 계산을 해주어야 함.

obstacle_cnt = [bottom[i] + top[H-i+1] for i in range(1, H+1)]
min_obstacle = min(obstacle_cnt)
min_cnt = obstacle_cnt.count(min_obstacle)

print(min_obstacle, min_cnt)