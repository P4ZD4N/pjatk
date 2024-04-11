#!/bin/bash

read -p "Enter path to file: " FILE

LINES=$(wc -l < "$FILE")

FIRST_PART=$(head -n $(("$LINES"/3)) "$FILE")
LAST_PART=$(tail -n $(("$LINES"/3)) "$FILE")
MIDDLE_PART=$(sed -n "$((${LINES}/3 + 1)), $((${LINES} - ${LINES}/3))p" "$FILE")

echo "$LAST_PART" > $FILE
echo "$MIDDLE_PART" >> $FILE
echo "$FIRST_PART" >> $FILE
