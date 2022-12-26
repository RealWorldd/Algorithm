#include "bits/stdc++.h"
using namespace std;
int n;
vector<pair<int, string>> V;
int main(void){
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num; string s;
        cin >> num >> s;
        V.push_back({num, s});
    }
    for (auto i: V) {
        for (int j = 0; j < i.second.size(); j++) {
            for (int k = 0; k < i.first; k++) {
                cout << i.second[j];
            }
        }
        cout << "\n";
    }
}