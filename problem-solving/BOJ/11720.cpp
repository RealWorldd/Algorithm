#include "bits/stdc++.h"
using namespace std;
int n;
string s;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> s;
    int sum = 0;
    for (int i = 0; i < s.size(); i++) {
        int num = (int) s[i] - 48;
        sum += num;
    }
    cout << sum << '\n';
}