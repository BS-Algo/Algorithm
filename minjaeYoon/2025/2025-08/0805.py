# 그림 확대
def solution(picture, k):
    answer = []

    for i in range(len(picture)):
        std = ''
        for j in range(len(picture[0])):
            std += picture[i][j] * k
        
        for _ in range(k):
            answer.append(std)
    
    
    return answer

print(solution(["x.x", ".x.", "x.x"], 3))