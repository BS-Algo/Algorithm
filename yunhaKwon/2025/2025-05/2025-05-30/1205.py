N, score, P = map(int, input().split())
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