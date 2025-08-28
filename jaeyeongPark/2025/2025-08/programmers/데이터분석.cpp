#include <string>
#include <vector>
#include <algorithm>
using namespace std;


vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> result;
    //먼저 ext보다 작은 val_ext를 뽑음
    for(int i = 0;i<data.size();i++){
        if(ext == "code"){
            if(data[i][0]<val_ext){
                result.push_back(data[i]);
            }
        } else if(ext == "date"){
            if(data[i][1]<val_ext){
                result.push_back(data[i]);
            }
        } else if(ext == "maximum"){
            if(data[i][2]<val_ext){
                result.push_back(data[i]);
            }
        } else if(ext == "remain"){
            if(data[i][3]<val_ext){
                result.push_back(data[i]);
            }
        }
    }
    // result 배열에서 sort_by를 기준으로 오름차순 정렬하기
    if(sort_by == "code"){
        sort(result.begin(), result.end(),[](const vector<int>& a,const vector<int>& b){
            return a[0] < b[0];
        });
    } else if(sort_by == "date"){
        sort(result.begin(), result.end(),[](const vector<int>& a,const vector<int>& b){
            return a[1] < b[1];
        });
    } else if(sort_by == "maximum"){
        sort(result.begin(), result.end(),[](const vector<int>& a,const vector<int>& b){
            return a[2] < b[2];
        });
    } else if(sort_by == "remain"){
        sort(result.begin(), result.end(),[](const vector<int>& a,const vector<int>& b){
            return a[3] < b[3];
        });
    }

    
    return result;
}