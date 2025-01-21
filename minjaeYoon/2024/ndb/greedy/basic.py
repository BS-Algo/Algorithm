# example 3-1
def coin(n):
    coin_types = [500, 100, 50, 10]
    count = 0
    
    for coin in coin_types:
        count += n // coin
        n %= coin
    
    return count

n = 1260
print(coin(n))

# 실전 문제 큰 수의 법칙
def bignum(arr, data):
    n, m, k = arr
    data.sort()
    first = data[n-1]
    second = data[n-2]
    result = 0
    while True:
        for i in range(k):
            if m == 0:
                break
            result += first
            m -= 1
        if m == 0:
            break 
        result += second
        m -= 1
    return result
arr = [5, 8, 3]
data = [2, 4, 5, 4, 6]
print(bignum(arr, data))

# 실전 문제 숫자 카드 게임
def card(arr, num):
    n, m = arr
    result = 0
    for i in range(n):
        min_num = min(num[i])
        result = max(result, min_num)
    return result

arr = [3, 3]
num = [
    [3, 1, 2],
    [4, 1, 4],
    [2, 2, 2]
]
print(card(arr, num))

# 실전 문제 1이 될 때 까지
def only(n, k):
    result = 0
    while n >= k:
        if n % k == 0:
            n /= k
            result += 1
        else:
            n -= 1
            result += 1
    return result

n = 25
k = 5
print(only(n, k))

def only2(n, k):
    result = 0
    while n >= k:
        while n % k != 0:
            n -= 1
            result += 1
        n //= k
        result += 1
        
    while n > 1:
        n -= 1
        result += 1
    
    return result

print(only2(n, k))

# example 4-1 (구현) 상하좌우
def wasd(n, plans):
    x, y = 1, 1
    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    move_types = ['L', 'R', 'U', 'D']
    
    for plan in plans:
        for i in range(len(move_types)):
            if plan == move_types[i]:
                nx = x + dx[i]
                ny = y + dy[i]
        if nx < 1 or ny < 1 or nx > n or ny > n:
            continue
        x, y = nx, ny
        
    return x, y

n = 5
plans = ['R', 'R', 'R', 'U', 'D', 'D']

print(wasd(n, plans))

# example 4-2 시각 (완전 탐색으로 풀기 및 이중 for 문 복습용 문제)
def time(n):
    cnt = 0
    for i in range(n+1):
        for j in range(60):
            for k in range(60):
                if '3' in str(i) + str(j) + str(k):
                    cnt += 1
    return cnt

n = 5
print(time(n))

# 실전문제 4-2 왕실의 나이트
def knight(coor):
    row = int(coor[1])
    column = int(ord(coor[0])) - int(ord('a')) + 1
    
    steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
    
    result = 0
    for step in steps:
        nxt_row = row + step[0]
        nxt_column = column + step[1]
        
        if nxt_row >= 1 and nxt_row <= 8 and nxt_column >= 1 and nxt_column <= 8:
            result += 1 
    return result

coor = 'a1'
print(knight(coor))

# 실전 문제 4-3 게임 개발 (전형적인 시뮬레이션 문제)
n, m = map(int, input().split())

d = [[0] * m for _ in range(n)]

x, y, direction = map(int, input().split())

d[x][y] = 1

arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
    
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3
        
cnt = 1
turn_log = 0
while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    
    if d[nx][ny] == 0 and arr[nx][ny] == 0:
        d[nx][ny] = 1
        x, y = nx, ny
        cnt += 1
        turn_log = 0
        continue
    else:
        turn_log += 1
    
    if turn_log == 4:
        nx = x - dx[direction]
        ny = y - dy[direction]
        
        if arr[nx][ny] == 0:
            x, y = nx, ny
        else:
            break
        turn_log = 0
        
print(cnt)

# 클래스화, OOP 예시
class RobotCleaner:
    def __init__(self, n, m, r, c, d, room_map):
        self.n = n  # 세로 크기
        self.m = m  # 가로 크기
        self.x = r  # 로봇 x 좌표
        self.y = c  # 로봇 y 좌표
        self.direction = d  # 방향
        self.room = room_map  # 방 상태
        self.cleaned = [[0] * m for _ in range(n)]  # 청소 상태
        self.cleaned[r][c] = 1  # 시작 위치 청소
        self.cleaned_count = 1  # 청소한 칸 수
        
        # 방향 벡터 (북, 동, 남, 서)
        self.dx = [-1, 0, 1, 0]
        self.dy = [0, 1, 0, -1]
    
    def turn_left(self):
        """로봇을 왼쪽으로 회전"""
        self.direction = (self.direction - 1) % 4
    
    def can_clean(self, nx, ny):
        """청소 가능한 칸인지 확인"""
        return (0 <= nx < self.n and 0 <= ny < self.m and 
                self.cleaned[nx][ny] == 0 and self.room[nx][ny] == 0)
    
    def can_move_back(self, nx, ny):
        """후진 가능한지 확인"""
        return (0 <= nx < self.n and 0 <= ny < self.m and 
                self.room[nx][ny] == 0)
    
    def clean(self):
        """청소 시작"""
        turn_count = 0
        
        while True:
            # 1. 왼쪽으로 회전
            self.turn_left()
            nx = self.x + self.dx[self.direction]
            ny = self.y + self.dy[self.direction]
            
            # 2. 청소 가능한 공간이면 전진
            if self.can_clean(nx, ny):
                self.cleaned[nx][ny] = 1
                self.x, self.y = nx, ny
                self.cleaned_count += 1
                turn_count = 0
                continue
            else:
                turn_count += 1
            
            # 3. 네 방향 모두 확인한 경우
            if turn_count == 4:
                # 후진 좌표 계산
                nx = self.x - self.dx[self.direction]
                ny = self.y - self.dy[self.direction]
                
                # 후진 가능하면 후진
                if self.can_move_back(nx, ny):
                    self.x, self.y = nx, ny
                else:
                    break
                turn_count = 0
        
        return self.cleaned_count

# 입력 처리
n, m = 4, 4
r, c, d = 1, 1, 0
room_map = [
    [1, 1, 1, 1],
    [1, 0, 0, 1],
    [1, 1, 0, 1],
    [1, 1, 1, 1]
]

# 로봇 청소기 실행
robot = RobotCleaner(n, m, r, c, d, room_map)
result = robot.clean()
print(result)  # 3

#-------------------------------------------------------------
# DFS/BFS, stack / deque / queue, 재귀 함수
# 재귀 복습
def recursive_function():
    print('재귀')
    recursive_function()

recursive_function()

def re_recursive_function(i):
    if i == 100:
        return
    print(i, '번째 재귀', i + 1, '번째 재귀')
    re_recursive_function(i + 1)
    print(i, '종료')

re_recursive_function(1)

# 팩토리얼 복습
def factorial_iterative(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

def factorial_recursive(m):
    if n <= 1:
        return 1
    return n * factorial_recursive(m-1)

print('반복', factorial_iterative(5))
print('재귀', factorial_recursive(5))

# DFS 복습
INF = 999999999

graph = [
    [0, 7, 5],
    [7, 0, INF],
    [5, INF, 0]
]
        
print(graph)

# python은 인접 행렬을 리스트로

graph = [[] for _ in range(3)]

graph[0].append((1, 7))
graph[0].append((2, 5))

graph[1].append((0, 7))

graph[2].append((0, 5))

print(graph)

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end = ' ')
    
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)
            
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

dfs(graph, 1, visited)

# BFS 복습
# 탐색 시작 노드 큐에 넣기
# 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
# 바로 윗 과정을 끝까지 반복

from collections import deque

def bfs(graph, start, visited):
    # deque 라이브러리 사용하기
    queue = deque([start])
    # 시작 노드 방문 처리
    visited[start] = True
    # 큐가 빌 때 까지 반복, 전부 방문 처리하기?
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        # 해당 노드와 연결되면서 방문 처리 안 된 원소 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

bfs(graph, 1, visited)

# 실전 5-3 음료수 얼려 먹기
n, m = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(map(int, input())))

def dfs_ice(x, y):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    
    # 미방문 처리
    if graph[x][y] == 0:
        graph[x][y] = 1
        
        # 상하좌우 전부 재귀 처리
        dfs_ice(x-1, y)
        dfs_ice(x, y-1)
        dfs_ice(x+1, y)
        dfs_ice(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs_ice(i, j) == True:
            result += 1
            
print(result)

# 실전 문제 5-4 미로 탈출
from collections import deque
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))
    
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs_road(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[nx][ny] + 1
                queue.append((nx, ny))
                
    return graph[n -1][m - 1]

print(bfs_road(0, 0))

# 정렬 알고리즘 복습
# 선택 정렬
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(arr)):
    min_index = i
    for j in range(i+1, len(arr)):
        if arr[min_index] > arr[j]:
            min_index = j
    arr[i], arr[min_index] = arr[min_index], arr[i]
    
print(arr)

# 삽입 정렬
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(arr)):
    for j in range(i, 0, -1):
        if arr[j] < arr[j-1]:
            arr[j], arr[j-1] = arr[j-1], arr[j]
        else:
            break

print(arr)

# 퀵 정렬
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(arr, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    
    while left <= right:
        while left <= end and arr[left] <= arr[pivot]:
            left += 1
        while right > start and arr[right] >= arr[pivot]:
            right -= 1
            
        if left > right:
            arr[right], arr[pivot] = arr[pivot], arr[right]
        else:
            arr[left], arr[right] = arr[right], arr[left]
    
    quick_sort(arr, start, right-1)
    quick_sort(arr, right+1, end)
    
quick_sort(arr, 0, len(arr)-1)
print(arr)

# 퀵 정렬 (py)
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort_py(arr):
    if len(arr) <= 1:
        return arr
    
    pivot = arr[0]
    tail = arr[1:]
    
    left_side = [x for x in tail if x <= pivot]
    right_side = [y for y in tail if y > pivot]
    
    return quick_sort_py(left_side) + [pivot] + quick_sort_py(right_side)

print(quick_sort_py(arr))

# 계수 정렬
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

cnt = [0] * (max(arr) + 1)

for i in range(len(arr)):
    cnt[arr[i]] += 1
    
for i in range(len(cnt)):
    for j in range(cnt[i]):
        print(i, end =' ')
        
# 정렬 라이브러리
arr = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

result = sorted(arr)
print(result)

arr.sort()
print(arr)

arr = [('바나나', 2), ('사과', 5), ('당근', 3)]

def sorting(arr):
    return data[1]

result = sorted(arr, key=sorting)
print(result)

# 실전 문제 6-2 위에서 아래로
n = int(input())

arr = []

for i in range(n):
    arr.append(int(input()))
    
arr = sorted(arr, reverse=True)

for i in arr:
    print(i, end=' ')
    
# 실전 문제 6-3 성적이 낮은 순서로 출력하기

n = int(input())

arr = []

for i in range(n):
    input_data = input().split()
    
    arr.append(input_data[0], int(input_data[1]))
    
arr = sorted(arr, key=lambda student: student[1])

for student in arr:
    print(student[0], end=' ')
    
# 실전 문제 6-4 두 배열의 원소 교체
n, k = map(int, input().split())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

a.sort()
b.sort(reverse=True)

for i in range(k):
    if a[i] < b[i]:
        a[i], b[i] = b[i], a[i]
    else:
        break
    
print(sum(a))

# 이진 탐색 - 순차 탐색
def sequential_search(n, target, arr):
    for i in range(n):
        if arr[i] == target:
            return i + 1

input_data = input().split()
n = int(input_data[0])
target = input_data[1]

arr = input().split()

print(sequential_search(n, target, arr))

# 이진 탐색 : 재귀
def binary_search(arr, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    
    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr, target, start, mid -1)
    else:
        return binary_search(arr, target, mid +1, end)
    
n, target = list(map(int, input().split()))

arr = list(map(int, input().split()))

result = binary_search(arr, target, 0, n-1)

if result == None:
    print('x')
else:
    print(result+1)
    
    
# 이진 탐색 - 반복
def binary_search_repeat(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        
        if arr[mid] == target:
            return mid
        
        elif arr[mid] > target:
            end = mid -1
        
        else:
            start = mid +1
    
    return None

n, target = list(map(int, input().split()))

arr = list(map(int, input().split()))

result = binary_search_repeat(arr, target, 0, n -1)
if result == None:
    print('X')
    
else:
    print(result + 1)