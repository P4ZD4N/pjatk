#include <string>

auto isPalindrome(std::string sentence) -> bool {

    for (int i = 0, j = sentence.size() - 1; i < sentence.size() && j != 0; i++, j--) {
        if (sentence.at(i) != sentence.at(j)) return false;
    }

    return true;
}