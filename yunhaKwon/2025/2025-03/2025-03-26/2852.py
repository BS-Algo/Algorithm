n = int(input())  # 점수 변화 횟수
team1_score = 0
team2_score = 0
team1_time = 0
team2_time = 0
last_time = 0
leading_team = 0  #0 : 동점, 1 : 팀1 리드, 2 : 팀2 리드

for _ in range(n):
    team, time = input().split()
    min, sec = map(int, time.split(":"))
    current_time = min * 60 + sec  #초 단위로 변환

    #점수 갱신
    if team == '1':
        team1_score += 1
    else:
        team2_score += 1

    #현재 리드 중인 팀이 있는 경우, 그 팀의 리드 시간 누적
    if leading_team == 1:
        team1_time += current_time - last_time
    elif leading_team == 2:
        team2_time += current_time - last_time

    #리드 상태 갱신
    if team1_score > team2_score:
        leading_team = 1
    elif team1_score < team2_score:
        leading_team = 2
    else:
        leading_team = 0  # 동점

    last_time = current_time  # 마지막 점수 변경 시간 갱신

# 경기 종료 후, 마지막 리드 시간을 반영
if leading_team == 1:
    team1_time += 2880 - last_time
elif leading_team == 2:
    team2_time += 2880 - last_time

# 초 단위를 MM:SS 형식으로 변환하여 출력
print(f"{team1_time // 60:02}:{team1_time % 60:02}")
print(f"{team2_time // 60:02}:{team2_time % 60:02}")
