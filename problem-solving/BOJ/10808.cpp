#include "bits/stdc++.h"
using namespace std;
int alpha[26];
string s;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> s;
    for (char c: s) {
        alpha[c - 97]++;
    }
    for (int i: alpha) {
        cout << i << " ";
    }
}