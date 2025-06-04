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

# DP
def solution(babbling):
    answer = 0
    able = ["aya", "ye", "woo", "ma"]
    
    for bab in babbling:
        
        def can_speak(s, used):
            if not s:  
                return True
            
            for i, word in enumerate(able):
                
                if used[i] or not s.startswith(word):
                    continue
                    
                
                used[i] = True
                if can_speak(s[len(word):], used):
                    return True
                used[i] = False  
                
            return False
        
        if can_speak(bab, [False] * 4):
            answer += 1
            
    return answer

babbling = ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	

print(solution(babbling))

# itertools
def solution(babbling):
    from itertools import permutations
    
    answer = 0
    able = ["aya", "ye", "woo", "ma"]
    
    # 모든 가능한 조합을 미리 생성
    valid_words = set()
    
    # 1~4단어의 모든 순열 생성
    for r in range(1, 5):  # 1, 2, 3, 4단어
        for perm in permutations(able, r):
            valid_words.add(''.join(perm))
        # 이 방법을 생각 못한
    
    for bab in babbling:
        if bab in valid_words:
            answer += 1
            
    return answer

babbling = ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	

print(solution(babbling))

# 개선
def solution(babbling):
    answer = 0
    able = ["aya", "ye", "woo", "ma"]
    
    # 미리 모든 가능한 조합을 생성 (한 번만)
    valid_words = set()
    
    # 1단어
    for word in able:
        valid_words.add(word)
    
    # 2단어 조합
    for i in range(4):
        for j in range(4):
            if i != j:
                valid_words.add(able[i] + able[j])
    
    # 3단어 조합  
    for i in range(4):
        for j in range(4):
            if i != j:
                for k in range(4):
                    if k != i and k != j:
                        valid_words.add(able[i] + able[j] + able[k])
    
    # 4단어 조합
    from itertools import permutations
    for perm in permutations(able):
        valid_words.add(''.join(perm))
    
    for bab in babbling:
        if bab in valid_words:
            answer += 1
            
    return answer

babbling = ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	

print(solution(babbling))