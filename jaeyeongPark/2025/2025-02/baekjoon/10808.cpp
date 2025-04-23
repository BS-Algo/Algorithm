#include <iostream>
using namespace std;

int main() {
    string s;
    cin >> s; // 문자열 입력

    int alphabet[26] = {0}; // 알파벳 개수 저장 배열 초기화

    for (char c : s) { 
        alphabet[c - 'a']++; // 해당 알파벳 카운트 증가
    }

    for (int i = 0; i < 26; i++) {
        cout << alphabet[i] << " ";
    }

    return 0;
}
