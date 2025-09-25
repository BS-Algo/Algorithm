# 09/23~09/25 : 동원 예비군
# 2016년
# https://school.programmers.co.kr/learn/courses/30/lessons/12901

def solution(a, b):
    from datetime import datetime, date
    
    weekdays = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    
    day = date(2016, a, b)  
    
    answer = day.weekday()
    
    return weekdays[answer]

print(solution(5, 24))

# 메서드 없이
def getDayName(a,b):
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    day = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    return day[(sum(month[:a-1])+b-1)%7]