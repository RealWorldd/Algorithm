#include "bits/stdc++.h"
using namespace std;
/**
 * 3차원 BFS로 최단거리 구하기 문제랑 비슷했다.
 * 2차원과 달리 dz라는 변수를 한개 더 추가해 위아래도 검사하게 해서 풀었다.
 */
int n, m, h; // N행 M열
int board[102][102][102];
int dist[102][102][102];
int dx[6] = {1, 0, -1, 0, 0, 0};
int dy[6] = {0, 1, 0, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    queue<tuple<int, int, int>> Q; //2개 순서쌍은 pair 3개부터는 tuple
    cin >> m >> n >> h;
    for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> board[k][i][j];
                if(board[k][i][j] == 1){
                    Q.push({k, i, j}); //토마토의 전염이 동시 다발적으로 일어나기 때문에 1인 좌표를 큐에 미리 추가
                }
                if(board[k][i][j] == 0){
                   dist[k][i][j] = -1; // 방문 여부를 확인하기 위해 -1로 초기화
                }
            }
        }
    }
    while (!Q.empty()) {
        auto cur = Q.front(); Q.pop();
        for (int dir = 0; dir < 6; dir++) {
            int nz = get<0>(cur) + dz[dir]; //tuple은 get으로 순서쌍 꺼냄
            int nx = get<1>(cur) + dx[dir];
            int ny = get<2>(cur) + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue; //범위 초과 여부 검사
            if(dist[nz][nx][ny] >= 0) continue; //익지 않은 토마토만 검사하면 되기 때문에 -1 값만 찾으면 된다.
            dist[nz][nx][ny] = dist[get<0>(cur)][get<1>(cur)][get<2>(cur)] + 1; //익은 토마토 기준으로 상하좌우위아래 +1 로 거리 계산(거리 = 걸리는 일)
            Q.push({nz, nx, ny});
        }
    }
    int ans = 0;
    for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dist[k][i][j] == -1) {
                    cout << -1; //-1이 있으면 갇혀있는 토마토가 있다는 뜻이기에 -1 출력
                    return 0;
                }
                ans = max(ans, dist[k][i][j]); //dist 배열을 전수검사해서 가장 큰 숫자가 최소 걸리는 일
            }
        }
    }
    cout << ans;
}