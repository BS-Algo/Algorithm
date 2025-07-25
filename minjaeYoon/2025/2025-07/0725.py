# 외계어 사전
def solution(spell, dic):
    from collections import Counter
    
    s_cnt = Counter(spell)
    
    for word in dic:
        w_cnt = Counter(word)
        
        if s_cnt == w_cnt:
            return 1
    return 2

print(solution(["p", "o", "s"], ["sod", "eocd", "qixm", "adio", "soo"]))

# set, sorted 등 정렬 메서드 활용해서 풀기