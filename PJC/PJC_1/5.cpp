#include <iostream>

auto welcome() -> void {

    using namespace std;

    auto name = string("");

    cout << "Input your name: ";
    cin >> name;

    if (name == "Einstein") {
        cout << "I know you!";
        return;
    }

    cout << "Greetings.";
}