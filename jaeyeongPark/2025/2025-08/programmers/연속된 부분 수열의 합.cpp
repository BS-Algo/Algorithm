#include <string>
#include <vector>
#include <iostream>

using namespace std;

// 시작포인터와 끝 포인터를 이동하면서 그 사이의 원소 값을 모두 포함하는 수열 찾기
// 합이 k보다 작으면 right를 늘려서 범위 확장(비내림차순이라서)
// 합이 k보다 크면 left를 줄여서 범위를 축소
// 합이 정확히 k면 구간 후보로 저장, 길이가 가장 짧은 구간, 동일하면 시작 인덱스가 가장 작은 구간을 선택

vector<int> solution(vector<int> sequence, int k) {
    int n = sequence.size();
    int left = 0, right = 0;
    long long sum = sequence[0];
    
    int bestL = 0, bestR = n-1;
    
    while(left<n && right<n){
        if(sum == k){
            if((bestR-bestL)>(right-left)){
                bestL = left;
                bestR = right;
            }
            sum -= sequence[left++];
        }
        else if(sum < k){
            right++;
            if(right < n) sum += sequence[right];
        }
        else{
            sum -= sequence[left++];
        }
    }
    
    return {bestL,bestR};
}

