#include "bits/stdc++.h"
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int arr[3];
    while(1){
        for(int i = 0; i < 3; i++) {
            cin >> arr[i];
            if(arr[i] == 0) return 0;
        }
        sort(arr, arr + 3);
        if(pow(arr[0], 2) + pow(arr[1], 2) == pow(arr[2], 2)){
            cout << "right" << "\n";
            continue;
        }
        cout << "wrong" << "\n";
    }
}