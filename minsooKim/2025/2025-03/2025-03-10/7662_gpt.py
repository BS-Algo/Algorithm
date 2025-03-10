import sys
import heapq

input = sys.stdin.readline  # 빠른 입력 처리

T = int(input())
for _ in range(T):
    k = int(input())
    min_heap = []  # 최소 힙 (최솟값 관리)
    max_heap = []  # 최대 힙 (최댓값 관리)
    visited = {}  # 삭제 여부 체크

    for i in range(k):
        word, num = input().split()
        num = int(num)

        if word == 'I':  # 삽입 연산
            heapq.heappush(min_heap, (num, i))  # 최소 힙
            heapq.heappush(max_heap, (-num, i))  # 최대 힙
            visited[i] = True  # 현재 값이 유효함을 표시
        elif word == 'D':  # 삭제 연산
            if num == -1:  # 최솟값 삭제
                while min_heap and not visited[min_heap[0][1]]:  
                    heapq.heappop(min_heap)  # 이미 삭제된 원소 정리
                if min_heap:
                    visited[min_heap[0][1]] = False  # 현재 최소값을 무효화
                    heapq.heappop(min_heap)  # 실제 삭제
            else:  # 최댓값 삭제
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)  # 이미 삭제된 원소 정리
                if max_heap:
                    visited[max_heap[0][1]] = False  # 현재 최대값을 무효화
                    heapq.heappop(max_heap)  # 실제 삭제


    if min_heap and max_heap:
        print(-max_heap[0][0], min_heap[0][0])  # 최대값, 최소값 출력
    else:
        print("EMPTY")
