#include <iostream>

auto guessTheNumber() -> void {

    using namespace std;

    auto randomNumber = rand() % 100 + 1;
    auto guessedNumber = -1;

    while (guessedNumber != randomNumber) {
        cout << "Guest a number: ";
        cin >> guessedNumber;

        if (guessedNumber > randomNumber) {
            cout << "Too big. Try lower!" << '\n';
        }

        if (guessedNumber < randomNumber) {
            cout << "Too small. Try higher!" << '\n';
        }
    }

    cout << "Congratulations! " << guessedNumber << " = " << randomNumber;
}