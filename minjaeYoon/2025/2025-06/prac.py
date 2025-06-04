# 옹알이 (1)
def solution(babbling):
    answer = 0
    able = ["aya", "ye", "woo", "ma"]
    
    for bab in babbling:
        # 불가능 조건
        if len(bab) > 10 or len(bab) < 2 or len(bab) == 9:
            answer += 0
        # 단어만 일치
        elif bab in able:
            answer += 1
        # 조합 따지기 (2단어) => 4, 5, 6
        elif 4 <= len(bab) <= 6:
            for i in range(4):
                for j in range(4):
                    if i != j:
                        sentence = able[i] + able[j]
                        if bab == sentence:
                            answer += 1
        # 조합 따지기 (3단어)
        elif 7 <= len(bab) <= 8:
            for i in range(4):
                for j in range(4):
                    if i != j:
                        for k in range(4):
                            if k != i and k != j :
                                sentence = able[i] + able[j] + able[k]
                                if bab == sentence:
                                    answer += 1
        # 조합 따지기 (4단어)
        elif len(bab) == 10:
            for i in range(4):
                for j in range(4):
                    for k in range(4):
                        for l in range(4):
                            if l != i and l != j and l != k:
                                sentence = able[i] + able[j] + able[k] + able[l]
                                if bab == sentence:
                                    answer += 1 
        
    return answer

babbling = ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	

print(solution(babbling))