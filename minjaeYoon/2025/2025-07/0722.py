# 치킨 쿠폰
def solution(chicken):
    answer = 0
    coupons = chicken
    
    while coupons >= 10:
        service = coupons // 10
        answer += service
        
        coupons = coupons % 10 + service
        
    return answer

chicken = 1081

print(solution(1081))