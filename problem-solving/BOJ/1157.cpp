#include "bits/stdc++.h"
using namespace std;
string s;
int main(void) {
    cin >> s;
    vector<pair<int, char>> V;
    for (int i = 0; i < s.size(); i++) {
        if(s[i] >= 97 && s[i] <= 122) {
            V.push_back({0, s[i] - 32});
        }else {
            V.push_back({0, s[i]});
        }
        int count = 0;
        for (int j = 0; j < V.size(); j++) {
            if(s[i] == V[j].second || (char)(s[i] - 32) == V[j].second){
                count++;
                if(count >= 2) {
                    V.pop_back();
                }
            }
        }
    }
    for (int i = 0; i < s.size(); i++) {
        for (auto &j: V) {
            if (s[i] == j.second || (char) (s[i] - 32) == j.second) {
                j.first++;
            }
        }
    }
    int m = 0;
    int count = 0;
    char ans;
    for (auto i: V) {
        m = max(m, i.first);
    }
    for (auto i: V) {
        if (i.first == m) {
            ans = i.second;
            count++;
        }
        if (count >= 2) {
            cout << "?";
            return 0;
        }
    }
    cout << ans;
}