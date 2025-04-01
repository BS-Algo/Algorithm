#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	const int INF = 1e9;
	int N;
	cin >> N;

	vector<vector<int>> W;
	vector<int> cities;

	W.assign(N, vector<int>(N));

	// 2차원배열 입력받기
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> W[i][j];
		}
	}
	
	//도시 순서
	for (int i = 0; i < N; i++) {
		cities.push_back(i);
	}

	//최소 비용
	int min_cost = INF;


	//조건을 확인하기 전에 한번은 무조건 실행되게 하기 위해서 do-while문 사용 
	do {
		int cost = 0;
		bool valid = true;

		// 현재 순열에서 비용 계산
		for (int i = 0; i < N - 1; i++) {
			// 이동이 불가능한 경우
			if (W[cities[i]][cities[i + 1]] == 0) {
				valid = false; 
				break;
			}
			cost += W[cities[i]][cities[i + 1]];
		}

		// 마지막 도시에서 출발 도시로 돌아가는 비용 추가
		if (valid && W[cities[N - 1]][cities[0]] != 0) {
			cost += W[cities[N - 1]][cities[0]];
			min_cost = min(min_cost, cost);
		}
	} 	
	//next_permutation으로 모든 순열 확인 -> 배열 또는 백터의 다음 순열을 자동으로 생성해주는 함수
	while (next_permutation(cities.begin() + 1, cities.end()));

	cout << min_cost << "\n";

	return 0;

	


}