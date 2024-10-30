#include <string>
#include <fmt/ranges.h>

auto reduceAdjacentWhitespaces(const std::string& toReduce) -> std::string {

    auto result = std::string();
    auto inWhitespace = false;

    for (char ch : toReduce) {
        if (isspace(ch)) {
            if (!inWhitespace) {
                result += ' ';
                inWhitespace = true;
            }
        } else {
            result += ch;
            inWhitespace = false;
        }
    }

    if (!result.empty() && result.back() == ' ') result.pop_back();

    return result;
}