#include "bits/stdc++.h"
using namespace std;
int n;
vector<pair<int, string>> V;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        V.push_back({s.size(), s});
    }
    sort(V.begin(), V.end());
    V.erase(unique(V.begin(), V.end()), V.end());
    for (auto i: V) {
        cout << i.second << '\n';
    }
}