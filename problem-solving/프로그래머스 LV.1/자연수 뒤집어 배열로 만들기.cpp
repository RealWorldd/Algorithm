//문제 설명
//자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
//
//제한 조건
//n은 10,000,000,000이하인 자연수입니다.
//입출력 예
//n	return
//12345	[5,4,3,2,1]
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(long long n) {
    vector<int> v;
    string str = to_string(n);
    for(auto i : str){
        v.push_back(i - '0');
    }
    reverse(v.begin(), v.end());

    return v;

}