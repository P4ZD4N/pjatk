#include <iostream>
#include <vector>

auto operations() -> void;
auto translation() -> void;
auto comparing() -> void;
auto sumOfTwo(std::vector<int> numbers, int val) -> bool;

auto main() -> int {

    using namespace std;

    auto choice = -1;

    while(choice < 0 || choice > 3) {
        cout << "[0] Basic operations on text variables" << '\n';
        cout << "[1] Digits translation" << '\n';
        cout << "[2] Comparing entered values" << '\n';
        cout << "[3] Finding pair of numbers with a concrete sum" << '\n';
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

        case 3: {
            vector<int> numbers = {};
            auto val = -1;

            while (numbers.size() < 5) {
                auto number = -1;

                cout << "Enter number: ";
                cin >> number;

                numbers.push_back(number);
            }

            cout << "Enter value: ";
            cin >> val;

            sort(numbers.begin(), numbers.end());

            cout << sumOfTwo(numbers, val);
        }
        break;

        default: cout << "Incorrect input!";
    }

    return 0;
}