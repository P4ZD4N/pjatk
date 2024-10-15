#include <vector>
#include <string>
#include <set>
#include <fmt/ranges.h>

auto printWithoutDuplicates(std::vector<std::string> strings) -> void {

    using namespace std;

    auto uniqueStrings = set<string>{};

    for (string str : strings) {
        auto iterator = uniqueStrings.find(str);

        if (iterator == uniqueStrings.end()) {
            uniqueStrings.insert(str);
            fmt::print("{} ", str);
        }
    }
}
