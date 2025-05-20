import sys
from collections import deque
input = sys.stdin.readline

# 가수의 수 N, 보조PD의 수 M
n, m = map(int, input().split())

# 보조PD들의 출연 순서 리스트
orders = [list(map(int, input().split())) for _ in range(m)]
# 가수 번호들을 노드로 사용하는 그래프
singers = [[] for _ in range(n+1)]
# 각 가수 번호의 작업 순서(차수)
degrees = [0] * (n+1)

# 보조PD들의 출연 순서를 하나씩 가져와서 작업 수행
for order in orders:
    # 첫 번째 원소의 경우 출연하는 가수의 숫자이므로 제외하고 수행
    for i in range(1, len(order)-1):
        # 각 가수 번호를 뒤에 오는 가수 번호와 연결
        singers[order[i]].append(order[i+1])
        # 뒤에 있는 가수 번호가 후순위이므로 차수를 1 증가
        degrees[order[i+1]] += 1

# 차수대로 작업을 수행하기 위해 차수가 0인 가수 번호들만 가져와서 작업
dq = deque([i for i in range(1, n+1) if degrees[i] == 0])

# 사이클 발생을 체크해야 하므로 리스트에 저장해서 추후 조건문 수행
result = []

# 작업할 가수가 있다면 계속 작업 수행
while dq:
    # 현재 순서의 가수 작업 수행
    cur_singer = dq.popleft()
    result.append(cur_singer)
    
    # 현재 가수 다음에 나올 수 있는 가수들이 존재한다면 작업 수행
    for next_singer in singers[cur_singer]:
        # 차수를 1 감소
        degrees[next_singer] -= 1
        
        # 만약 차수가 0이라면 처리할 수 있는 순서이므로 result 리스트에 삽입
        if degrees[next_singer] == 0:
            dq.append(next_singer)

# 만약 result에 모든 가수가 들어있다면 사이클이 없으므로 정답 출력
if len(result) == n:
    for num in result:
        print(num)
else:
    print(0)