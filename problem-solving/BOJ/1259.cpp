#include "bits/stdc++.h"
using namespace std;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    while (cin >> s) {
        if (stoi(s) == 0) {
            return 0;
        }
        string ans = "yes";
        for (int i = 0; i < s.size() / 2; i++) {
            if (s[i] != s[s.size() - 1 - i]) {
                ans = "no";
            }
        }
        cout << ans << "\n";
    }
}
