# 가위 바위 보
# if 문 나열 하기
def solution(rsp):
    answer = ''
    rsp = list(rsp)
    for i in range(len(rsp)):
        if rsp[i] == '0':
            answer += '5'
        elif rsp[i] == '2':
            answer += '0'
        elif rsp[i] == '5':
            answer += '2'
    return answer

# 메서드 활용하기
def solution(rsp):
    return rsp.translate(str.maketrans('025', '502'))

# 각도 구하기
def solution(angle):
    if angle<=90:
        return 1 if angle < 90 else 2
    else:
        return 3 if angle < 180 else 4
    
# 양꼬치 
def solution(n, k):
    return (n * 12000) + ((k - n // 10) * 2000)

# 모스부호(1)
def solution(letter):
    morse = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
}
    letter = list(letter.split())
    return ''.join(morse[i] for i in letter)

letter = ".... . .-.. .-.. ---"	
print(solution(letter))