#include <iostream>
#include <vector>
#include <string>

auto boxPrint(std::vector<std::string> words, char border = '*') -> void;
auto reversedWords(const std::string &sentence) -> std::string;
auto manipulation() -> void;

auto main() -> int {
    using namespace std;

    auto choice = -1;

    while(choice < 0 || choice > 3) {
        cout << "[0] Box print" << '\n';
        cout << "[1] Reversed words" << '\n';
        cout << "[2] Manipulation of data display format" << '\n';
        cout << "Choose program: ";
        cin >> choice;
    }

    cout << '\n';

    switch (choice) {
        case 0:
            boxPrint({"a", "quick", "brown", "fox"});
            boxPrint({"siema", "jestem", "wiktor", ":)"}, '=');
            boxPrint({"a", "quick", "brown", "fox"}, '#');
            boxPrint(std::vector<std::string>{"a", "quick", "brown", "fox"}, '#');
            boxPrint({""});
            boxPrint({});
            boxPrint({}, '#');
            boxPrint({"", "hmmmm", ""});
            boxPrint({"", "", ""});
        break;

        case 1:
            cout << reversedWords("Ala ma kota") << '\n';
            cout << reversedWords("Ala") << '\n';
            cout << reversedWords("Siema jestem wiktor :>") << '\n';
            cout << reversedWords("") << '\n';
            cout << reversedWords("1 2 3") << '\n';
        break;

        case 2:
            manipulation();
        break;

        default: cout << "Incorrect input!";
    }

    cout << "\n";

    return 0;
}
