def solution(numLog):
    answer = ''
    for i in range(1, len(numLog)):
        diff = numLog[i] - numLog[i-1]
        if diff == 1:
            answer += 'w'
        elif diff == -1:
            answer += 's'
        elif diff == 10:
            answer += 'd'
        elif diff == -10:
            answer += 'a'
    return answer
	
def solution(log):
    res=''
    joystick=dict(zip([1,-1,10,-10],['w','s','d','a']))
    for i in range(1,len(log)):
        res+=joystick[log[i]-log[i-1]]
    return res




numLog = [0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1]

print(solution(numLog))

# 1이냐 10이냐로 두고 이후에 크냐 작으냐로 두기