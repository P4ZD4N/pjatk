#include <iostream>

auto operations() -> void;
auto translation() -> void;
auto comparing() -> void;

auto main() -> int {

    using namespace std;

    auto choice = -1;

    while(choice < 0 || choice > 2) {
        cout << "[0] Basic operations on text variables" << '\n';
        cout << "[1] Digits translation" << '\n';
        cout << "[2] Comparing entered values" << '\n';
        cout << "Choose program: ";
        cin >> choice;
    }

    cout << "\n";

    switch (choice) {
        case 0:
            operations();
        break;

        case 1:
            translation();
        break;

        case 2:
            comparing();
        break;

        default: cout << "Incorrect input!";
    }

    return 0;
}