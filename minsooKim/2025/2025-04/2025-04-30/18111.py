import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
ground = [list(map(int, input().split())) for _ in range(N)]

min_time = float('inf')
answer_height = 0

for target_height in range(257):
    time = 0
    block = B
    for i in range(N):
        for j in range(M):
            height = ground[i][j]
            if height < target_height: # 높이가 부족한 경우 블록을 쌓아야 함
                diff = target_height - height
                print(diff)
                time += diff
                block -= diff
            else: # 높이가 초과할 경우 블록을 제거. 이때는 2초니까 *2
                diff = height - target_height
                time += 2 * diff
                block += diff
    if block >= 0:
        if time < min_time or (time == min_time and target_height > answer_height):
            min_time = time
            answer_height = target_height

print(min_time, answer_height)
