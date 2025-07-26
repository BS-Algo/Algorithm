# 정사각형으로 만들기
def solution(arr):
    answer = [[]]
    
    width = len(arr)
    length = len(arr[0])    
    std = max(width, length)
    
    answer = [[0 for _ in range(std)] for _ in range(std)]
    
    for i in range(width):
        for j in range(length):
            answer[i][j] = arr[i][j]
    
    return answer

print(solution([[572, 22, 37], [287, 726, 384], [85, 137, 292], [487, 13, 876]]))