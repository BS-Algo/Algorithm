N = int(input())
arr = []

cnt_1 = 0
cnt_2 = 0
answer = 0

for i in range(N):
    team, time = input().split()
    m, s = map(int, (time.split(':')))

    if team == '1':
        if answer == 0:
            cnt_1 += 48 * 60 - (60 * m + s)
        answer += 1

        if answer == 0:
            if cnt_2 > 0:
                cnt_2 = cnt_2 - (48 * 60 - (60 * m + s))

    else:
        if answer == 0:
            cnt_2 += 48 * 60 - (60 * m + s)
        
        answer -= 1

        if answer == 0:
            if cnt_1 > 0:
                cnt_1 = cnt_1 - (48 * 60  - (60 * m + s))
print('{:0>2}:{:0>2}'.format(cnt_1//60,cnt_1%60))
print('{:0>2}:{:0>2}'.format(cnt_2//60,cnt_2%60))