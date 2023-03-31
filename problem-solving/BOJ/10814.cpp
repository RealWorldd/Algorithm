#include "bits/stdc++.h"
using namespace std;
int n;
bool compare(pair<int, string> a, pair<int, string> b){
    if(a.first == b.first){
        return false;
    }
    return a.first < b.first;
}
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<pair<int, string>> V;
    cin >> n;
    while (n--) {
        int age;
        string name;
        cin >> age >> name;
        V.push_back({age, name});
    }
    stable_sort(V.begin(), V.end(), compare);
    for (auto i: V) {
        cout << i.first << " " << i.second << "\n";
    }
}