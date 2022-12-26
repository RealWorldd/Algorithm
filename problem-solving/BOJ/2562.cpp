#include "bits/stdc++.h"
using namespace std;
vector<int> V;
int main(void){
    for (int i = 0; i < 9; i++) {
        int num;
        cin >> num;
        V.push_back(num);
    }
    int index = 0;
    int M = 0;
    for (auto i: V) {
        M = max(M, i);
    }
    for (int i = 0; i < V.size(); i++) {
        if (V[i] == M) {
            index = i + 1;
        }
    }
    cout << M << "\n" << index;
}