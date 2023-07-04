#include "bits/stdc++.h"
using namespace std;
#define X first
#define Y second
int n, m;
string board[102];
bool vis_w[102][102];
bool vis_b[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        string line;
        cin >> line;
        board[i] = line;
    }
    int w_res = 0;
    int b_res = 0;
    int temp = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] != 'W' || vis_w[i][j] == 1) continue;
            w_res += pow(temp, 2);
            temp = 0;
            queue<pair<int, int>> q;
            q.push({j, i});
            vis_w[i][j] = 1;
            temp++;
            while (!q.empty()) {
                pair<int, int> cur = q.front();
                q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(board[ny][nx] != 'W' || vis_w[ny][nx]) continue;
                    q.push({nx, ny});
                    vis_w[ny][nx] = 1;
                    temp++;
                }
            }
        }
    }
    w_res += pow(temp, 2);
    temp = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if(board[i][j] != 'B' || vis_b[i][j] == 1) continue;
            b_res += pow(temp, 2);
            temp = 0;
            queue<pair<int, int>> q;
            q.push({j, i});
            vis_b[i][j] = 1;
            temp++;
            while (!q.empty()) {
                pair<int, int> cur = q.front();
                q.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(board[ny][nx] != 'B' || vis_b[ny][nx]) continue;
                    q.push({nx, ny});
                    vis_b[ny][nx] = 1;
                    temp++;
                }
            }
        }
    }
    b_res += pow(temp, 2);
    cout << w_res << " " << b_res;
}