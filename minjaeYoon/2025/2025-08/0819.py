# 정수를 나선형으로 배치하기

def solution(n):
    answer = [[0] * n for _ in range(n)]
    directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    current = 0
    row, col = 0, 0
    
    for num in range(1, n**2 + 1):
        answer[row][col] = num
        
        dr, dc = directions[current]
        ndr, ndc = row + dr, col + dc
        
        if ndr < 0 or ndr >= n or ndc < 0 or ndc >= n or answer[ndr][ndc] != 0:
            current = (current + 1) % 4
            dr, dc = directions[current]
            ndr, ndc = row + dr, col + dc
            
        row, col = ndr, ndc
            
    return answer

print(solution(4))