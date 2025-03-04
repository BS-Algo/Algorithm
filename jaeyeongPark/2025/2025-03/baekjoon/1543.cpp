#include <iostream>
#include <string>
using namespace std;

int main() {
    string document, word;
    getline(cin, document);
    getline(cin, word);

    int count = 0, pos = 0;
    while ((pos = document.find(word, pos)) != string::npos) {
        count++;
        pos += word.length(); // 겹치지 않도록 이동
    }

    cout << count << "\n";
    return 0;
}
