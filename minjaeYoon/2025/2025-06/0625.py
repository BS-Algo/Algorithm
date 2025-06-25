# 공돌리기
def solution(numbers, k):
    answer = 0
    lmt = 0
    index_lmt = 0
    num_lmt = len(numbers)
    
    while lmt < k:
        answer = numbers[index_lmt]
        index_lmt += 2
        
        # 인덱스가 범위를 벗어나면 초기화
        if index_lmt >= num_lmt:
            index_lmt = index_lmt % num_lmt
        
        lmt += 1
    
    return answer

numbers = [1, 2, 3]	
k = 3

print(solution(numbers, k))
