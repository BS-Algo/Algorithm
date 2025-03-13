N = int(input())  # 단어 개수
words = [input().strip() for _ in range(N)]  # 모든 단어 받기
main_word = words[0]  # 기준 단어
result = 0  # 비슷한 단어 개수

# 기준 단어의 문자 개수 세기
main_count = [0] * 26
for char in main_word:    
    main_count[ord(char) - ord('A')] += 1    

# 다른 단어들과 비교
for i in range(1, N):
    current_word = words[i]
    
    # 비교 단어의 문자 개수 세기
    current_count = [0] * 26
    for char in current_word:
        current_count[ord(char) - ord('A')] += 1
        
    # 문자 개수 차이 확인
    diff_count = 0
    for j in range(26):
        diff_count += abs(main_count[j] - current_count[j])

    # 비슷한 단어 조건 확인
    length_diff = abs(len(main_word) - len(current_word))
    
    # 1. 길이가 같을 때 → 한 글자만 바꿨는지 확인
    if diff_count == 0:
        result += 1    
    elif length_diff == 0 and (diff_count == 2):
        result += 1
    # 2. 길이가 1 다를 때 → 한 글자 추가/삭제 확인
    elif length_diff == 1 and (diff_count == 1):
        result += 1

print(result)
