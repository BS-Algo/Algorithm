import heapq
import sys
input = sys.stdin.readline

n = int(input())
time = []
for i in range(n):
    start, end = map(int, input().split())
    time.append([start, end])
time.sort()

q = []
heapq.heappush(q, time[0][1])

for i in range(1, n):
    if q[0] > time[i][0]: # 앞 강의의 종료 시간이 현재 강의의 시작 시간보다 크면 => 강의실 추가
        heapq.heappush(q, time[i][1]) # 현재 종료 시간 추가
    else: # 앞 강의의 종료 시간이 현재 강의의 시작 시간보다 같거나 작으면 => 강의실 추가없이 같은 강의실에서 이어서 하면 됨
        heapq.heappop(q) # 앞 강의 종료 시간 삭제
        heapq.heappush(q, time[i][1]) # 현재 강의 종료 시간 추가

print(len(q))