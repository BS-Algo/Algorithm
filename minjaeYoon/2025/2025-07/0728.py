# 캐릭터의 좌표
def solution(keyinput, board):
    answer = [0, 0]
    
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    
    x, y = board
    max_x = x // 2
    max_y = y // 2
    
    for i in range(len(keyinput)):
        if keyinput[i] == "up":
            answer[0] += dx[0]
            answer[1] += dy[0]
        elif keyinput[i] == "down":
            answer[0] += dx[1]
            answer[1] += dy[1]
        elif keyinput[i] == "left":
            answer[0] += dx[2]
            answer[1] += dy[2]
        elif keyinput[i] == "right":
            answer[0] += dx[3]
            answer[1] += dy[3]

        # 경계값 계산하기
        answer[0] = max(-max_x, min(max_x, answer[0]))
        answer[1] = max(-max_y, min(max_y, answer[1]))
        
    return answer

print(solution(["left", "right", "up", "right", "right"], [11, 11]))

# dx, dy 만들고 nx, ny 두는 방식이 나을거 같은데
# left면 nx = x + dx[0], ny = y + dy[0]