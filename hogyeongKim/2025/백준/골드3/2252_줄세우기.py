import sys
from collections import deque
input = sys.stdin.readline

# 학생의 수 N, 비교횟수 M, 위상정렬 시 필요한 그래프 연결 리스트와 차수 리스트
n, m = map(int, input().split())
graphs = [[] for _ in range(n+1)]
degrees = [0] * (n+1)

# 비교할 학생을 입력 받아 그래프로 연결하고 뒤에 서야 하는 학생의 차수를 1 증가
for _ in range(m):
    a, b = map(int, input().split())
    graphs[a].append(b)
    degrees[b] += 1

# 차수가 가장 낮은 작업부터 수행해야 하므로 차수가 0인 학생들을 queue에 삽입
dq = deque([i for i in range(1, n+1) if degrees[i] == 0])

# 정답을 저장할 result
result = []

while dq:
    # 가장 먼저 들어간 학생을 정답 리스트에 저장
    cur_student = dq.popleft()
    result.append(cur_student)
    
    # 현재 학생과 연결되어 있는 학생들의 차수를 1 감소하고, 차수가 0인 학생들을 다시 queue에 삽입
    for next_student in graphs[cur_student]:
        degrees[next_student] -= 1
        
        if degrees[next_student] == 0:
            dq.append(next_student)

# 순서를 신경 쓸 필요는 없으므로 별도의 정렬 조건은 추가할 필요 없다
print(*result)