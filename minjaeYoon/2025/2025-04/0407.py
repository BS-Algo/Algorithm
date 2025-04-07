# 2의 영역
def solution(arr):
    answer = []
    indices = []
    
    for i in range(len(arr)):
        if arr[i] == 2:
            indices.append(i)
    
    if not indices:
        return [-1]
    
    if len(indices) == 1:
        return [2]
    
    answer += arr[indices[0]:indices[-1]+1]
    
    return answer

arr = [1, 2, 1, 4, 5, 2, 9]	
print(solution(arr))