# 문자열 재정렬
data = input()
res = []
val = 0

for x in data:
    if x.isalpha():
        res.append(x)
    else:
        val += int(x)
        
res.sort()

if val != 0:
    res.append(str(val))
    
print(''.join(res))