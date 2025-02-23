# 문자열 뒤집기
s = list(map(int, input())) 
# 0001100
print(s)
cnt0 = 0
cnt1 = 0
start = s[0]

if start == 1:
    cnt0 += 1
else:
    cnt1 += 1
    
for i in range(len(s)-1):
    if s[i] != s[i+1]:
        if s[i+1] == 1:
            cnt0 += 1
        else:
            cnt1 += 1

print(min(cnt0, cnt1))        
        
        

