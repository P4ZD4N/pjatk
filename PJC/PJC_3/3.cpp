#include <vector>
#include <string>
#include <algorithm>

auto findFirstNumberInFirstPart(const std::string& s) -> std::string::const_iterator {
    for (auto it = s.begin(); it != s.end(); it++) {
        if (isdigit(*it)) {
            return it;
        }
    }
    return s.end();
}

auto findFirstNumberInSecondPart(const std::string& s) -> std::string::const_iterator {
    for (auto it = s.begin() + s.find('_'); it != s.end(); it++) {
        if (isdigit(*it)) {
            return it;
        }
    }
    return s.end();
}

auto naturalSort(std::vector<std::string>& strings) -> std::vector<std::string> {

    auto const isUnderscorePresent = strings[0].find('_') != std::string::npos;

    if (isUnderscorePresent) {

        std::ranges::sort(strings, std::ranges::less(), [](const std::string& s) {
            auto underscore = s.find('_');
            return std::string(*findFirstNumberInFirstPart(s), underscore);
        });

        std::ranges::sort(strings, [](const std::string& s1, const std::string& s2) {
            auto s1Underscore = s1.find('_');
            auto s2Underscore = s2.find('_');

            auto s1FirstPartNumber = std::string(*findFirstNumberInFirstPart(s1), s1Underscore);
            auto s2FirstPartNumber = std::string(*findFirstNumberInFirstPart(s2), s2Underscore);

            auto s1Dot = s1.find('.');
            auto s2Dot = s2.find('.');

            auto s1SecondPartNumber = std::string(*findFirstNumberInSecondPart(s1), s1Dot);
            auto s2SecondPartNumber = std::string(*findFirstNumberInSecondPart(s2), s2Dot);

            if (s1FirstPartNumber == s2FirstPartNumber) return s1SecondPartNumber < s2SecondPartNumber;

            return s1FirstPartNumber < s2FirstPartNumber;
        });

        return strings;
    }

    std::ranges::sort(strings, std::ranges::less(), [](const std::string& s) {
        return s.size();
    });

    return strings;
}