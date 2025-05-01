# 빈 배열에 추가, 삭제하기 
def solution(arr, flag):
    answer = []
    for i in range(len(flag)):
        if flag[i]:
            answer += [arr[i]] * (arr[i]*2)
        elif not flag[i]:
            if arr[i] <= len(answer):
                del answer[-arr[i]:]
            else:
                answer.clear()
            
    return answer

arr = [3, 2, 4, 1, 3]	
flag = [True, False, True, False, False]

print(solution(arr, flag))