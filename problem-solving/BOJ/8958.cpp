#include "bits/stdc++.h"
using namespace std;
int n;
vector<string> V;
int main(void) {
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        V.push_back(s);
    }
    for (int i = 0; i < V.size(); i++) {
        int count = 0; int ans = 0;
        for (int j = 0; j < V[i].size(); j++) {
            if (V[i][j] == 'O') {
                count++;
                ans += count;
                continue;
            }
            if (V[i][j] == 'X') {
                count = 0;
            }
        }
        cout << ans << '\n';
    }
}