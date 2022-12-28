#include "bits/stdc++.h"
using namespace std;
int n;
vector<pair<int, int>> V;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        V.push_back({a, b});
    }
    for (auto i: V) {
        cout << i.first + i.second << '\n';
    }
}