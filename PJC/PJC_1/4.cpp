#include <iostream>
#include <vector>

// Finding pair of numbers with a concrete sum

auto sumOfTwo(std::vector<int> numbers, int val) -> bool {

    using namespace std;

    auto left = 0;
    auto right = numbers.size() - 1;

    while (left < right) {
        int sum = numbers[left] + numbers[right];

        if (sum == val) {
            return true;
        } else if (sum < val) {
            left++;
        } else {
            right--;
        }
    }

    return false;
}