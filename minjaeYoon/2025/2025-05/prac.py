# 무작위로 K개의 수 뽑기
def solution(arr, k):
    answer = []
    log = set()
    for num in arr:
        if num not in log:
            log.add(num)
            answer.append(num)
            if len(answer) == k:
                break
    while len(answer) < k:
        answer.append(-1)    
    
    return answer

arr = [0, 1, 1, 2, 2, 3]
k = 3

print(solution(arr, k))