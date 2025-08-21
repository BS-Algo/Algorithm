#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
//mat의 길이만큼 연속된 i,j 값이 있는지 만약에 mat가 5야 그러면 가로로i+mat동안 전부 -1인지, j+mat 개만큼 전부 -1인지
//만약에 아니면 i랑 j를 +를 해주면서 확인해보기 전부 돌았지만 아니면 mat를 다음값으로 넘김
//이때 중요한거는 mat가 내림차순으로 되어있어야함 큰수부터 비교해봐야하기 때문

//함수를 만들어서 그 구간에 -1이 아니면 바로 리턴

bool can(vector<vector<string>>& park,int x, int y, int size){
    // park의 가로 세로
    int rows = park.size();
    int cols = park[0].size();
    
    if(x+size > rows || y+size>cols) return false;
    for(int i = x;i<x+size;i++){
        for(int j = y;j<y+size;j++){
            if(park[i][j] != "-1") return false;
        }
    }
    return true;
    
    
}

int solution(vector<int> mats, vector<vector<string>> park) {
    // mat 내림차순 정렬
    sort(mats.begin(),mats.end(),greater<int>());
    // park의 가로 세로
    int rows = park.size();
    int cols = park[0].size();

    
    for(int a= 0;a<mats.size();a++){
        int size= mats[a];
        for(int i = 0;i<rows;i++){
           for(int j = 0;j<cols;j++){
               if(can(park,i,j,size)){
                   return size;
               }
           }
        }    
    }
    return -1;
    
}