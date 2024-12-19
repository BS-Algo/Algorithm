people, rounds = map(int, input().split())
score = list(map(int, input().split()))

people_lst = []
for i in range(people):
    total_score = sum(score[i + people * k] for k in range(len(score) // people))
    people_lst.append([i + 1, total_score])

max_score = max([player[1] for player in people_lst])
winners = [player for player in people_lst if player[1] == max_score]

winner = max(winners, key=lambda x: x[0])

print(winner[0])
