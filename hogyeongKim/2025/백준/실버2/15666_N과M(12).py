# 문제 설명이 잘못되어 있음. 주의해서 풀 것.

N, M = map(int, input().split())
num_lst = sorted(list(set(map(int, input().split()))))
N = len(num_lst)  # 중복 제거 후 개수 다시 계산

path = []
def back(start):
    if len(path) == M:
        print(*path)
        return
            
    for i in range(start, N):
        path.append(num_lst[i])
        back(i)
        path.pop()
        
back(0)