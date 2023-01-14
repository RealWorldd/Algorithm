#include "bits/stdc++.h"
using namespace std;
int t;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> t;
    while (t--) {
        stack<char> S;
        string str;
        cin >> str;
        S.push(str[0]);
        for (int i = 1; i < str.size(); i++) {
            if (!S.empty()) {
                if (S.top() == '(' && str[i] == ')') {
                    S.pop();
                    continue;
                }
            }
            S.push(str[i]);
        }
        if (!S.empty()) {
            cout << "NO" << "\n";
            continue;
        }
        cout << "YES" << "\n";
    }
}