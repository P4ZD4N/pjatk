#include <vector>
#include <algorithm>
#include <fmt/ranges.h>

auto handleEvenCase(int firstHalfSum, int secondHalfSum, std::vector<int>& numbers) -> void {

    for (int i = 0; i < numbers.size(); i++) {
        if (i < numbers.size() / 2) {
            firstHalfSum += numbers[i];
            continue;
        }
        secondHalfSum += numbers[i];
    }

    if (firstHalfSum > secondHalfSum) {
        sort(numbers.begin(), numbers.begin() + numbers.size() / 2);
    }

    if (firstHalfSum < secondHalfSum) {
        sort(numbers.begin() + numbers.size() / 2, numbers.end());
    }
}

auto handleOddCase(int firstHalfSum, int secondHalfSum, std::vector<int>& numbers) -> void {

    for (int i = 0; i < numbers.size(); i++) {
        if (i <= numbers.size() / 2 - 1) {
            firstHalfSum += numbers[i];
            continue;
        }
        if (i == numbers.size() / 2) {
            continue;
        }
        secondHalfSum += numbers[i];
    }

    if (firstHalfSum > secondHalfSum) {
        sort(numbers.begin(), numbers.begin() + numbers.size() / 2);
    }

    if (firstHalfSum < secondHalfSum) {
        sort(numbers.begin() + numbers.size() / 2, numbers.end());
    }
}

auto sortBiggerHalf(std::vector<int>& numbers) -> void {

    using namespace std;

    auto firstHalfSum = 0;
    auto secondHalfSum = 0;

    if (numbers.size() % 2 == 0) {
        handleEvenCase(firstHalfSum, secondHalfSum, numbers);
    }

    handleOddCase(firstHalfSum, secondHalfSum, numbers);
}