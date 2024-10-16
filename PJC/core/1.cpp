#include <iostream>
#include <vector>
#include <string>

auto findLongestWord(std::vector<std::string> words) -> std::string {

    using namespace std;
    auto longestWord = string("");

    for (const string& word : words)
        if (word.size() > longestWord.size())
            longestWord = word;

    return longestWord;
}

auto printHorizontalBorder(int numberOfChars, char border) -> void {
    using namespace std;
    for (int i = 0; i <= numberOfChars + 1; i++) {
        cout << border;
    }
}

auto printWordWithSpacesAndBorders(std::string word, int sizeOfLongestWord, char border) -> void {
    using namespace std;

    if (word.size() == sizeOfLongestWord) {
        cout << border << word << border << '\n';
        return;
    }

    const auto numberOfSpaces = sizeOfLongestWord - word.size();
    cout << border << word.append(numberOfSpaces, ' ') << border << '\n';
}

auto boxPrint(std::vector<std::string> words, char border = '*') -> void {

    using namespace std;
    const auto longestWord = findLongestWord(words);

    cout << '\n' << '\n';

    printHorizontalBorder(longestWord.size(), border);

    cout << '\n';

    for (string word : words) {
        printWordWithSpacesAndBorders(word, longestWord.size(), border);
    }

    printHorizontalBorder(longestWord.size(), border);
}