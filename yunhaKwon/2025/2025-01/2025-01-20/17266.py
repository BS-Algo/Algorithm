N = int(input()) #굴다리 길이
M = int(input()) #가로등 개수
loc = list(map(int, input().split())) #가로등 위치
ans = 0

if len(loc) == 1:
    ans = max(loc[0], N - loc[0]) #가로등 위치에서 시작점 or 끝점까지의 길이 중 더 큰 것 선택

else:
    for i in range(M):
        if i == 0: #시작점에서 첫 가로등 위치까지 길이
            h = loc[i]
        elif i == M-1: #끝점에서 마지막 가로등 위치까지 길이
            h = N - loc[i]
        else: #첫 가로등, 마지막 가로등 제외한 중간 가로등들인 경우
            dist = loc[i] - loc[i-1] #가로등과 가로등 사이 길이
            if dist % 2 == 0: #가로등 사이 길이가 짝수인 경우
                h = dist // 2
            else: #가로등 사이 길이가 홀수인 경우
                h = dist // 2 + 1

        ans = max(h, ans)

print(ans)