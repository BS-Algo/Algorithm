def solution(a, b, g, s, w, t):
    # 파라매트릭 서치
    global n
    n = len(g)
    
    def calculate_minerals(cut):
        g_result, s_result, t_result = 0, 0, 0
        for i in range(n):
            if cut >= t[i]:
                repeat = (cut-t[i]) // (2*t[i]) + 1
                mx_carry = repeat * w[i]
                
                g_result += min(g[i], mx_carry)
                s_result += min(s[i], mx_carry)
                t_result += min(g[i] + s[i], mx_carry)
                
                
        return (g_result >= a and s_result >= b and t_result >= a + b)
    
    start, end = 0, 4*10**14
    result = 0
    
    while start < end:
        mid = (start + end) // 2
        
        if calculate_minerals(mid):
            end = mid
        else:
            start = mid+1
    
    return start