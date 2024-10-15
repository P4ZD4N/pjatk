#include <set>
#include <vector>
#include <fmt/ranges.h>

auto suffix(std::set<int> testSet, std::vector<int> testVector) -> bool {

    using namespace std;

    fmt::println("{}", testSet);
    fmt::println("{}", testVector);

    auto vectorSize = testVector.size();
    auto setSize = testSet.size();

    for (int i = vectorSize - 1, j = setSize - 1; i >= 0; i--, j--) {
        set<int>::iterator iterator = testSet.begin();
        advance(iterator, j);

        if (testVector[i] != *iterator) return false;
    }

    return true;
}
