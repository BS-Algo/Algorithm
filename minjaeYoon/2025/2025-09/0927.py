# K번째 수
# https://school.programmers.co.kr/learn/courses/30/lessons/42748

def solution(array, commands):
    answer = []
    for command in commands:
        start = command[0] - 1 
        end = command[1]        
        k = command[2] - 1     
        
        
        sliced = array[start:end]
        sliced.sort()
        
        
        if 0 <= k < len(sliced):
            answer.append(sliced[k])
        else:
            answer.append(None)
    
    return answer

print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))