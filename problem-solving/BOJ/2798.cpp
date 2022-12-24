#include "bits/stdc++.h"
using namespace std;
/**
 * 3중 for문을 돌리면 쉽게 해결할 수 있지만 뭔가 찝찝하다.
 * 나중에 시간복잡도를 줄여가면서 다시 풀어봐야겠다.
 */
int n, m;
vector<int> V;
int main(void) {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        V.push_back(num);
    }
    vector<int> VV;
    for (int i = 0; i < V.size(); i++) { //시간 복잡도 O(n^3)..
        for (int j = i + 1; j < V.size(); j++) {
            for (int k = j + 1; k < V.size(); k++) {
                if(V[i] + V[j] + V[k] > m) continue;
                VV.push_back(V[i] + V[j] + V[k]);
            }
        }
    }
    int ans = 0;
    for (auto i: VV) {
        ans = max(ans, i);
    }
    cout << ans;
}