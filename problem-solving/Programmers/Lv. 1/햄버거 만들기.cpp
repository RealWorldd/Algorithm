//예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
//
//상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
//
//제한사항
//1 ≤ ingredient의 길이 ≤ 1,000,000
//ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
//입출력 예
//ingredient	result
//[2, 1, 1, 2, 3, 1, 2, 3, 1]	2
//[1, 3, 2, 1, 2, 1, 3, 1, 2]	0
//입출력 예 설명
//        입출력 예 #1
//
//문제 예시와 같습니다.
//입출력 예 #2
//
//상수가 포장할 수 있는 햄버거가 없습니다.
#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    if(ingredient.size()<3){
        return 0;
    }
    vector<int> stack = {ingredient[0],ingredient[1], ingredient[2]};
    int result = 0;
    int index = 3;
    int size = ingredient.size()-1;
    while(true) {
        if(stack.size() >= 4){
            if(stack[stack.size()-1] == 1){
                if(stack[stack.size()-2] == 3){
                    if(stack[stack.size()-3] == 2){
                        if(stack[stack.size()-4] == 1){
                            result++;
                            stack.pop_back();
                            stack.pop_back();
                            stack.pop_back();
                            stack.pop_back();
                        }
                    }
                }
            }
        }
        if(index <= size){
            stack.push_back(ingredient[index]);
            index++;
        }else{
            break;
        }
    }
    return result;
}