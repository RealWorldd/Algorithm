#include "bits/stdc++.h"
using namespace std;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int a, b;
    while (cin >> a >> b) {
        if(a == 0 || b == 0) break;
        cout << a + b << '\n';
    }
}