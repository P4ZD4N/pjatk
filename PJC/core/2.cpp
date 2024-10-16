#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <numeric>
#include <fmt//ranges.h>

auto reversedWords(const std::string& sentence) -> std::string {

    using namespace std;

    vector<string> words = {};
    auto flag = 0;

    for (int i = 0; i < sentence.size(); i++) {
        if (isspace(sentence.at(i))) {
            words.push_back(sentence.substr(flag, i - flag));
            flag = i + 1;
        }

        if (i == sentence.size() - 1) {
            words.push_back(sentence.substr(flag, i - flag + 1));
        }
    }

    ranges::reverse(words);

    return format("{}", fmt::join(words, " "));
}
