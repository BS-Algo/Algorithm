T = int(input())
for _ in range(T):
    score = list(map(int, input().split()))
    score.sort()
    real_score = score[1:4]
    if real_score[-1] - real_score[0] >= 4:
        print("KIN")
    else:
        print(sum(real_score))