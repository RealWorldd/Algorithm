#include "bits/stdc++.h"
using namespace std;
int n;
int main(void){
    cin >> n;
    string s = "*";
    for (int i = 0; i < n; i++) {
        cout << s << "\n";
        s.append("*");
    }
}