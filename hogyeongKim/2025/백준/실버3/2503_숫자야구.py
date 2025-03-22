N = int(input())

hint_lst = [list(map(int, input().split())) for _ in range(N)]
result = set()

for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            if i == j or j == k or k == i:
                continue
            cnt = 0
            
            for hint in hint_lst:
                strike_cnt = 0
                ball_cnt = 0
                
                number = str(hint[0])
                strike = hint[1]
                ball = hint[2]
                 
                if number[0] == str(i):
                    strike_cnt += 1
                elif str(i) in number:
                    ball_cnt += 1
                    
                if number[1] == str(j):
                    strike_cnt += 1
                elif str(j) in number:
                    ball_cnt += 1
                    
                if number[2] == str(k):
                    strike_cnt += 1
                elif str(k) in number:
                    ball_cnt += 1
                
                if strike_cnt == strike and ball_cnt == ball:
                    cnt += 1
            if cnt == N:
                result.add(i * 100 + j * 10 + k)
                
print(len(result))