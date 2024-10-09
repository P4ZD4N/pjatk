#include <iostream>
#include <algorithm>

// Basic operations on text variables

auto operations() -> void {

    using namespace std;

    string word;

    cout << "Enter word: ";
    cin >> word;

    cout << word.at(0) << '\n';
    cout << "'" << word.at(word.size() - 1) << "'" << '\n';
    cout << word.size() << '\n';
    cout << '"' << word.at(word.size() / 2) << '"' << '\n';
    cout << "[" << word << "]" << '\n';

    string sortedWord = word;
    sort(sortedWord.begin(), sortedWord.end());

    cout << sortedWord;
}
