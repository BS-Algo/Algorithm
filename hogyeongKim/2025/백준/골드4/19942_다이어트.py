# 백트래킹
def back(idx, sum_p, sum_f, sum_s, sum_v, costs, path):
    global result, N, mp, mf, ms, mv
    
    if sum_p >= mp and sum_f >= mf and sum_s >= ms and sum_v >= mv:
        result.append([costs, path])
        return
            
    if idx == N:
        return
        
    # 선택했을 경우
    back(idx+1, sum_p+nutrients[idx][0], sum_f+nutrients[idx][1], sum_s+nutrients[idx][2], sum_v+nutrients[idx][3], costs+nutrients[idx][4], path + [idx])
    # 선택하지 않은 경우
    back(idx+1, sum_p, sum_f, sum_s, sum_v, costs, path)
    
N = int(input())

mp, mf, ms, mv = map(int, input().split())

nutrients = [tuple(map(int, input().split())) for _ in range(N)]

result = []
back(0, 0, 0, 0, 0, 0, [])

if not result:
    print(-1)
else:
    result.sort()
    print(result[0][0])
    for i in result[0][1]:
        print(i+1, end=' ')