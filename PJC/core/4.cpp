#include <vector>
#include <string>
#include <algorithm>
#include <fmt/ranges.h>

auto example(std::vector<std::string> left, std::vector<std::string> right) -> void {

    auto sortAndRemoveDuplicates = [](std::vector<std::string>& vec) -> void {
        std::ranges::sort(vec);
        auto duplicates = std::ranges::unique(vec);
        vec.erase(duplicates.begin(), duplicates.end());
    };

    sortAndRemoveDuplicates(left);
    sortAndRemoveDuplicates(right);

    fmt::println("Left: {} | Right: {}", left, right);
}