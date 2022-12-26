#include "bits/stdc++.h"
using namespace std;
int n;
string s;
int main(void){
    cin >> n;
    for (int i = 0; i < n; i++) {
        s.append(" ");
    }
    for (int i = n-1; i>=0; i--) {
        s.replace(i, 1, "*");
        cout << s << "\n";
    }
}