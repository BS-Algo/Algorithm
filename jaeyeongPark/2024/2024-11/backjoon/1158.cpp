#include<iostream>
#include<queue>
#include<vector>
using namespace std;


int main() {
	int N, K;
	cin >> N >> K;

	
	vector<int> arr;
	// 큐를 만들기
	queue<int> q;
	int num = 1;

	// 리스트 하나 만들기
	while (num <= N) {
		q.push(num);
		num++;
	}
	// 처음에 괄호 하나
	cout << "<";

	//큐에 K번째 요소 앞에 부분을 다 빼서 다시 뒤로 붙이고 K번째로왔을때 앞에거를 pop해서 새로운 배열에 추가
	while (q.size() > 1) {
		for (int i = 1; i < K; i++) {
			int tmp = q.front();
			q.pop();
			q.push(tmp);
		}
		arr.push_back(q.front());
		q.pop();
	}
	

	for (int i : arr) {
		cout << i << ", ";
	}
	cout << q.front();
	cout << ">";
}