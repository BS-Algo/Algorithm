import heapq

N = int(input())
classroom = []

for _ in range(N):
    S, T = map(int, input().split())
    classroom.append((S, T))

# 시작 시간을 기준으로 정렬
classroom.sort()

# 우선순위 큐 (최소 힙) 생성
q = []
heapq.heappush(q, classroom[0][1])  # 첫 번째 강의의 종료 시간을 넣음
# q = [3, 3, 3, 10, 4]

# classroom = [(1, 10), (2, 3), (2, 3), (2, 3), (2, 3), (3, 4)]
for i in range(1, N):
    start, end = classroom[i]
    # 2, 3

    # 현재 사용 중인 강의실 중 가장 빨리 끝나는 시간보다 새로운 강의 시작 시간이 크거나 같으면 같은 강의실 사용 가능
    if q[0] <= start:
        heapq.heappop(q)  # 기존 강의실에서 가장 빨리 끝나는 강의를 제거

    heapq.heappush(q, end)  # 새로운 강의 종료 시간을 추가

print(len(q))  # 필요한 최소 강의실 개수 출력
