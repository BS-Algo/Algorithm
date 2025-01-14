#include <iostream>
using namespace std;

int main(void)
{
    int M, N, min = 0, sum = 0;
    cin >> M >> N;
    
    for (int i=1; i*i <= N; i++){
        if (i*i >= M && i*i <= N){
            if (min == 0){
                min = i*i;
            }
            sum += i*i;
        }
    }
    
    if (sum == 0)
        cout << "-1\n";
        
    else 
        cout << sum << "\n" << min << "\n";

}