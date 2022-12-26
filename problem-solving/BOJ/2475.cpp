#include "bits/stdc++.h"
using namespace std;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> V;
    for (int i = 0; i < 5; i++) {
        int num;
        cin >> num;
        V.push_back(num);
    }
    int count = 0;
    for (int i = 0; i < V.size(); i++) {
        count += (V[i] * V[i]);
    }
    cout << count % 10;
}