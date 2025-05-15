# 커피 심부름
def solution(order):
    answer = 0
    menu = ["iceamericano", "americanoice", "hotamericano", "americanohot", "icecafelatte", "cafelatteice", "hotcafelatte", "cafelattehot", "americano"	, "cafelatte", "anything"]
    price = [4500, 4500, 4500, 4500, 5000, 5000, 5000, 5000, 4500, 5000, 4500 ]
    
    for i in range(len(order)):
        for j in range(len(menu)):
            if order[i] == menu[j]:
                answer += price[j]
    return answer

order = ["cafelatte", "americanoice", "hotcafelatte", "anything"]	

print(solution(order))