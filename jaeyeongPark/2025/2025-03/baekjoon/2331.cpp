#include <iostream>
#include <vector>
#include <map>
#include <cmath>


using namespace std;

int getNext(int num, int p) {
	int sum = 0;
	while (num > 0) {
		int digit = num % 10;
		// 거듭제곱 
		sum += pow(digit, p);
		num /= 10;
	}
	return sum;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int A, P;
	cin >> A >> P;

	map<int, int> visited; 
	int index = 1;
	int current = A;

	// 중복이 처음 등장하는 것을 찾기 위해서 반복
	while (visited[current] == 0){ 
		visited[current] = index++;
		current = getNext(current, P);
	}

	// 중복이 처음 나오기 전까지 개수 
	cout << visited[current] - 1 << "\n"; 

	return 0;

	


}