from collections import deque

n = int(input())
order_lst = deque(list(map(int, input().split())))

stack = []
now_lst = []
while order_lst:
    cur_order = order_lst.popleft()
    
    if now_lst:
        while stack:
            if stack[-1]== now_lst[-1] + 1:
                now_lst.append(stack.pop())
            else:
                break
        if cur_order == now_lst[-1] + 1:
            now_lst.append(cur_order)
        else:
            stack.append(cur_order)
    else:
        if cur_order == 1:
            now_lst.append(cur_order)
        else:
            stack.append(cur_order)

while stack:
    now_lst.append(stack.pop())

sorted_lst = sorted(now_lst)
if now_lst == sorted_lst:
    print("Nice")
else:
    print("Sad")