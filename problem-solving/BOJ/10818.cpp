#include "bits/stdc++.h"
using namespace std;
int n;
vector<int> V;
int main (void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        V.push_back(num);
    }
    int m = V[0];
    int M = V[0];
    for (int i = 0; i < V.size(); i++) {
        m = min(m, V[i]);
        M = max(M, V[i]);
    }
    cout << m << " " << M;
}