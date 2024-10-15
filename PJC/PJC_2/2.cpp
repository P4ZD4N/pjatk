#include <iostream>
#include <vector>
#include <fmt/ranges.h>

auto dotProduct(std::vector<int> firstVector, std::vector<int> secondVector) -> int {

    using namespace std;

    auto result = int();

    for (int i = 0; i < firstVector.size(); i++) {
        result += firstVector.at(i) * secondVector.at(i);
    }

    return result;
}