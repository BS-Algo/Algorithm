# 안전지대
def solution(board):
    answer = 0
    
    length = len(board)
    
    dx = [-1, -1, -1, 0, 0, 1, 1, 1] 
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    
    danger = []
    
    for i in range(length):
        for j in range(length):
            if board[i][j] == 1:
                danger.append((i, j))
    
    for x, y in danger:
        for k in range(8):
            nx = x + dx[k]
            ny = y + dy[k]
            
            if 0 <= nx < length and 0 <= ny < length:
                board[nx][ny] = 1
    
    for i in range(length):
        for j in range(length):
            if board[i][j] == 0:
                answer += 1
                
    
    return answer

# 1이 지뢰가 있으니 상하좌우 밑 대각선이 위험 지역
# 그러면 X로 바꿔버리고 1이면 그대로 두는 형식으로
# 대표적인 2차원 배열 문제



print(solution([[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]))
