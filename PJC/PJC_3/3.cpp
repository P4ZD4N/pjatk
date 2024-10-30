#include <vector>
#include <string>
#include <algorithm>

auto naturalSort(std::vector<std::string>& strings) -> std::vector<std::string> {
    std::ranges::sort(strings, std::ranges::less(), [](const std::string& s) {
        return s.size();
    });

    return strings;
}