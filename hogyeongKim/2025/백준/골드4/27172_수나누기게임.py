n = int(input())

cards = list (map(int, input().split()))
cards_set = set(cards)
mx_card = max(cards)
scores = [0] * (mx_card+1)

for card in cards:
    for i in range(2*card, mx_card + 1, card):
        if i in cards_set:
            scores[card] += 1
            scores[i] -= 1

for card in cards:
    print(scores[card], end=' ')