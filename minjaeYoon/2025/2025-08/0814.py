# 겹치는 선분의 길이
def solution(lines):
    answer = 0
    cnt = [0] * 201
    
    for start, end in lines:
        s_idx = start + 100
        e_idx = end + 100
        
        for i in range(s_idx, e_idx):
            cnt[i] += 1
            
    for i in range(201):
        if cnt[i] >= 2:
            answer += 1
    return answer

print(solution([[0, 1], [2, 5], [3, 9]]))