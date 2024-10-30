#include <iostream>
#include <vector>
#include <fmt/ranges.h>

auto elementsModificationWithUsageOfForLoop(std::vector<int>& numbers) -> void{
    for (int& number : numbers) {
        fmt::print("Enter number: ");
        std::cin >> number;
    }
}