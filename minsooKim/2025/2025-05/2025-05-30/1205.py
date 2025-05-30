N, score, P = map(int, input().split())
# N = 3, score = 90, P = 10
# 100 90 여기에 90이 들어가서 80 1 2 2 4등 
answer = N + 1
if N > 0:
    rank_lst = list(map(int, input().split()))
    if N == P and score <= rank_lst[-1]:
        print(-1)    
    else:
        for i in range(N):
            if score >= rank_lst[i]:
                answer = i + 1
                break
        print(answer)
else:
    print(1)