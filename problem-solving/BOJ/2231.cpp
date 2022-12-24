#include "bits/stdc++.h"
using namespace std;
/**
 * 가장 작은 생성자인거 못보고 삽질했다.
 * 문제 잘 읽는 습관을 들여야겠다.
 */
int n;
int main(void) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        string temp = to_string(i);
        int sum = i;
        for (int j = 0; j < temp.size(); j++) {
            if(temp[j] - '0' == 0) break;
            sum += (temp[j] - '0');
        }
        if (sum == n) {
            cout << stoi(temp); //생성자 찾으면 출력하고 종료
            return 0;
        }
    }
    cout << 0; //생성자 없으면 0 출력하고 종료
}