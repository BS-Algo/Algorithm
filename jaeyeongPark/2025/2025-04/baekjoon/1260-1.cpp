#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;



//인접리스트
vector<int> graph[1001];

bool visited[1001];

//dfs
void dfs(int node) {
	//현재 노드 출력
	cout << node << " ";
	visited[node] = true;

	for (int next : graph[node]) {
		if (!visited[next]) {
			dfs(next);
		}
	}
    //graph[1] = {2,3}
    //이런식으로 한번씩 반복됨 next = 2, 3이런식으로 재귀적으로 발생
}


void bfs(int start) {
	queue<int> q;

	//방문 초기화
	fill(visited, visited + 1001, false);
	//queue에 push
    q.push(start);
	visited[start] = true;


    //큐가 빌때까지 반복
	while (!q.empty()) {
        //큐의 첫번째를 노드로 정의한 후 제거
		int node = q.front(); 
		q.pop(); 
		cout << node << " "; 

		for (int next : graph[node]) {
			if (!visited[next]) {
				visited[next] = true;
				q.push(next);
					
				
			}
		}
	}
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int N, M, V;
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		//무방향 그래프라서 양쪽 모두 추가해야함
		graph[a].push_back(b);
		graph[b].push_back(a);
	}

	// 방문순서 때문에 정렬 sort(begin(),end())
	for (int i = 1; i <= N; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	fill(visited, visited + 1001, false);
	dfs(V);
	cout << "\n";

	bfs(V);
	cout << "\n";

	return 0;

	


}