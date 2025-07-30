# 1. 물고기가 가장 적은 어항에 1마리 추가(N개 어항이 똑같이 적다면 N개에 모두 추가)

# 2. 2개 이상 쌓여있는 어항은 따로 떼어내어 시계방향으로 90도 회전, 이후 이전의 높이를 길이로 하여
#    1개인 어항 위에 적재

# 3. 어항을 쌓을 수 없게 되면, 인접한 두 어항의 차를 d라고 했을 때, d//5 > 0인 경우 d 만큼
#    적은 물고기를 가진 어항에 물고기를 보내야 한다. 이는 모든 칸에서 동시에 일어난다.

# 4. 가장 왼쪽 어항들부터 아래에서 위로 펼쳐서 일렬로 만든다.

# 5. 가운데를 중심으로 왼쪽 N//2개를 180도 회전시켜 오른쪽 위에 쌓는다. 이 작업은 두번 수행한다.

# 6. 가장 왼쪽 어항부터 아래에서 위로 펼쳐서 일렬로 만든다.

# 7. 가장 물고기 수가 많은 어항과 가장 적은 어항의 차이가 K이하가 되려면 어항을 몇 번 정리해야 하는가?

# N은 4의 배수

import sys
input = sys.stdin.readline
dt = ((1, 0), (0, 1), (-1, 0), (0, -1))

cnt = 0
N, K = map(int, input().split())
fish = list(map(int, input().split()))

def add_fish():
    min_fish = min(fish)
    for i in range(N):
        if fish[i] == min_fish:
            fish[i] += 1

def rotate(idx):
    global N, fish
    levitation = list(fish[:idx+1])
    if all(isinstance(levitation[0], int)):
        levitation = [[x] for x in levitation]
    levitation = list(zip(*levitation))
    if not levitation:
        return
    fish = fish[idx+1:]
    for i in range(min(len(levitation), len(fish))):
        temp = []
        temp.extend(levitation[i])
        if isinstance(fish[i], list):
            temp.extend(fish[i])
        else:
            temp.append(fish[i])
        fish[i] = temp
    N = len(fish)

def rotate_reverse():
    global N, fish
    left = fish[:N//2]
    if isinstance(left[0], int):
        left = [[x] for x in left]
    levitation = list(zip(*left))
    fish = fish[N//2:]
    for t in range(2):
        for i in range(len(levitation)):
            if isinstance(fish[i], list):
                fish[i] = list(fish[i]) + list(levitation[i])
            else:
                fish[i] = [fish[i]] + list(levitation[i])
        N -= N // 2

def spread():
    x = len(fish)
    temp = [[0] * len(fish[i]) for i in range(x)]
    for i in range(x):
        for j in range(len(fish[i])):
            if fish[i][j] > 0:
                d = fish[i][j] // 5
                if d > 0:
                    for dx, dy in dt:
                        nx, ny = i + dx, j + dy
                        if 0 <= nx < len(fish) and 0 <= ny < len(fish[nx]):
                            temp[nx][ny] += d
                            temp[i][j] -= d
    for i in range(x):
        for j in range(len(fish[i])):
            fish[i][j] += temp[i][j]
            if fish[i][j] < 0:
                fish[i][j] = 0

def arrage():
    global N
    temp = []
    for i in range(len(fish)):
        if type(fish[i]) == list:
            temp.extend(fish[i])
        else:
            temp.append(fish[i])
    fish.clear()
    fish.extend(temp)
    N = len(fish)

def check():
    max_fish = max(fish)
    min_fish = min(fish)
    return max_fish - min_fish <= K

while not check():
    cnt += 1

    add_fish()

    while True:
        idx = 0
        if type(fish[0]) == list:
            height = len(fish[0])
        else:
            height = 1

        for i in range(len(fish)):
            if type(fish[i]) == int:
                idx = i
                break
        if height > N-idx:
            spread()
            arrage()
            break
        rotate(idx)

    rotate_reverse()
    spread()
    arrage()

print(fish)
print(cnt)