#include "bits/stdc++.h"
using namespace std;
/**
 * BFS 알고리즘을 알고 있다면 쉽게 풀 수 있는 문제인 것 같다.
 * BFS 알고리즘을 적용하고 필요한 변수값만 받아서 문제를 풀었다.
 */
#define X first
#define Y second
int board[27][27];
bool vis[27][27];
int n;
int dx[4] = {1, 0, -1, 0}; //Queue에 들어가 있는 원소 기준으로 상하좌우 탐색
int dy[4] = {0, 1, 0, -1};
int main(void) {
    cin >> n;
    for(int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%1d", &board[i][j]); //cin은 붙어있는 숫자열을 받을 수 없어서 scanf의 "%1d" 로 받음
        }
    }
    int num = 0; // 단지 개수
    vector<int> v; // 단지에 속하는 집의 수를 넣을 vector
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] == 0 || vis[i][j]) continue;
            num++; //새로운 queue를 받을 때 새로운 단지를 찾는 것 이므로 단지 개수 ++
            queue<pair<int, int>> Q;
            vis[i][j] = 1;
            Q.push({i, j});
            int area = 0;
            while (!Q.empty()) { //새로운 단지의 상하좌우 탐색하는 while문
                area++; //큐에서 pop 할 때 area++ 을 해 단지 크기 측정
                pair<int, int> cur = Q.front();
                Q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(vis[nx][ny] || board[nx][ny] != 1) continue;
                    vis[nx][ny] = 1;
                    Q.push({nx, ny});
                }
            }
            v.push_back(area);
        }
    }
    sort(v.begin(), v.end()); //오름차순 정렬
    cout << num << "\n";
    for (auto i: v) {
        cout << i << "\n";
    }
}