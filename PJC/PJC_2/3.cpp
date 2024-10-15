#include <vector>
#include <set>
#include <fmt/ranges.h>

auto iterateEveryNElements(std::vector<int> vec, int n) -> void {

    using namespace std;

    for (auto iterator = vec.begin(); iterator < vec.end(); iterator += n) {
        fmt::print("{} ", *iterator);
    }
}

auto iterateEveryNElements(std::set<int> set, int n) -> void {

    using namespace std;

    auto i = 0;

    for (auto iterator = set.begin(); iterator != set.end(); ++iterator) {
        if (i % n == 0) {
            fmt::print("{} ", *iterator);
        }

        i++;
    }
}

