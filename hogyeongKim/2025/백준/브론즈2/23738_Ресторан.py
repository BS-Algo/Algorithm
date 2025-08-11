word_dict = {
    'B': 'v',
    'E': 'ye',
    'H': 'n',
    'P': 'r',
    'C': 's',
    'Y': 'u',
    'X': 'h',
    'A': 'a',
    'K': 'k',
    'M': 'm',
    'O': 'o',
    'T': 't'
}

word = input()

for alp in word:
    print(word_dict[alp], end='')