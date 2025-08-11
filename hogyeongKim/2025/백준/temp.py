# N은 4의 배수
from collections import deque
import sys
input = sys.stdin.readline
dt = ((1, 0), (0, 1))

cnt = 0
n, k = map(int, input().split())
fish = list(map(int, input().split()))
fish = [[fish[i]] for i in range(n)]
# 1. 물고기가 가장 적은 어항에 1마리 추가(N개 어항이 똑같이 적다면 N개에 모두 추가)
def add_fish_to_min():
    min_fish = min(f[0] for f in fish)
    for i in range(n):
        if fish[i][0] == min_fish:
            fish[i][0] += 1 


# 2. 2개 이상 쌓여있는 어항은 따로 떼어내어 시계방향으로 90도 회전, 이후 이전의 높이를 길이로 하여
#    1개인 어항 위에 적재
def stack_and_fold():
    global fish
    # 첫번째 어항의 경우 예외로 쌓음
    new_fish = [[fish[1][0]], fish[0][0]]
    new_fish.extend(fish[2:])
    fish = new_fish
    
    # 적재해야하는 어항의 길이가 쌓아야 하는 어항의 수보다 작을 때까지 반복
    while len(fish[0]) < len(fish):
        # 2개 이상 쌓여있는 어항을 찾아 인덱스를 지정
        height = len(fish[0])
        width = height + 1
        
        if width > len(fish):
            break

        top = [fish[i][:] for i in range(width)]
        bottom = fish[width:]

        # 시계방향으로 90도 회전
        rotated = list(zip(*top))
        for row in rotated:
            row = list(row)
            row.reverse()
        
        # 쌓아야 하는 어항 위에 적재
        for i in range(len(fish)):
            if len(fish[i]) < height:
                fish[i].extend(rotated[i])



# 3. 어항을 쌓을 수 없게 되면, 인접한 두 어항의 차를 d라고 했을 때, d//5 > 0인 경우 d 만큼
#    적은 물고기를 가진 어항에 물고기를 보내야 한다. 이는 모든 칸에서 동시에 일어난다.
def adjust_fish():
    global fish
    change = []

    for i in range(len(fish)):
        for j in range(len(fish[i])):
            for dx, dy in dt:
                nx, ny = i + dx, j + dy
                if 0 <= nx < x and 0 <= ny < len(fish[nx]) and fish[i][j] > fish[nx][ny]:
                    d = fish[i][j] - fish[nx][ny]
                    d //= 5
                    if d > 0:
                        change.append((nx, ny, d))
                        change.append((i, j, -d))
    
    for x, y, d in change:
        fish[x][y] += d


# 4. 가장 왼쪽 어항들부터 아래에서 위로 펼쳐서 일렬로 만든다.

# 5. 가운데를 중심으로 왼쪽 N//2개를 180도 회전시켜 오른쪽 위에 쌓는다. 이 작업은 두번 수행한다.
def fold_half():
    global fish
    # 첫 번째 접기
    n2 = n //2 
    left, right  = [fish[i][:] for i in range(n2)], [fish[i][:] for i in range(n2, n)]
    left.reverse()
    new_fish = []
    for i in range(n2):
        new_fish.append(left[i], right[i])
    fish = new_fish

    # 두 번째 접기
    n4 = n2 // 2
    left, right = fish[:n4], fish[n4:n2]
    # 왼쪽 어항들을 180도 회전
    left.reverse()
    new_fish = []
    for i in range(n4):
        new_fish.append(left[i*2], left[i*2+1], right[i*2+1], right[i*2])
    fish = new_fish

# 6. 가장 왼쪽 어항부터 아래에서 위로 펼쳐서 일렬로 만든다.
def flatten():
    global fish
    new_fish = []
    for i in range(len(fish)):
        new_fish.extend(fish[i])
    fish = [[new_fish[i]] for i in range(n)]

# 7. 가장 물고기 수가 많은 어항과 가장 적은 어항의 차이가 K이하가 되려면 어항을 몇 번 정리해야 하는가?
def get_difference():
    global fish
    new_fish = [f[0] for f in fish]
    return max(new_fish) - min(new_fish) <= k

while not get_difference():
    cnt += 1
    add_fish_to_min()
    stack_and_fold()
    adjust_fish()
    flatten()
    fold_half()
    adjust_fish()
    flatten()

print(cnt)