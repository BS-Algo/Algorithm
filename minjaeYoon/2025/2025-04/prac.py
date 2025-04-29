# rny_string
def solution(rny_string):
    answer = ''
    rny_string = list(rny_string)
    
    for i in range(len(rny_string)):
        if rny_string[i] == 'm':
            rny_string[i] = 'rn'
    
    answer = ''.join(rny_string)
    
    return answer

rny_string = "masterpiece"

print(solution(rny_string))