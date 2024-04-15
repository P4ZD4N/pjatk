#!/bin/bash

read -p "Enter path (to add it to PATH system variable): " NEW_PATH

echo "Adding $NEW_PATH to PATH variable..."
export PATH="$PATH:$NEW_PATH"

echo "Done!"
echo "$PATH" | tr ':' '\n'

exit 0
