#include "bits/stdc++.h"
using namespace std;
/**
 * 실버3 문제 아닌 것 같다;; DFS로 접근해봤다.
 * 재귀도 사용해볼까 생각했지만 엄두가 안나서 스택으로 해결했다.
 */
int n;
vector<tuple<int, int, int>> V;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    stack<tuple<int, int, int>> S; //BFS는 큐, DFS는 스택
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        V.push_back({i, a, b});
    }
    vector<tuple<int, int, int>> VV;
    for (int i = 0; i < n; i++) {
        S.push({V[i]});
        while (!S.empty()) {
            tuple<int, int, int> cur = S.top();
            S.pop();
            if (get<0>(cur) + get<1>(cur) == n) { //반례 처리하느라 억지로 끼워 넣었다..
                VV.push_back(cur);
            }
            if (get<0>(cur) + get<1>(cur) > n) continue;
            for (int j = get<0>(cur) + get<1>(cur); j < n; j++) {
                tuple<int, int, int> temp = V[j];
                if (get<0>(temp) + get<1>(temp) > n) {
                    VV.push_back(cur);
                    continue;
                }
                get<2>(temp) += get<2>(cur);
                S.push(temp);
                VV.push_back(temp);
            }
        }
    }
    int ans = 0;
    for (auto i: VV) { //DFS로 찾은 pay값들의 최대를 찾는 과정
        ans = max(ans, get<2>(i));
    }
    cout << ans;
}