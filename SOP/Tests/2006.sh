#!/bin/bash

read -p "Enter path to file: " FILE


LINES=$(wc -l < "$FILE")

if [ $(($LINES % 2)) -ne 0 ] ; then
  FIRST_PART=$(head -n $(("$LINES"/2+1)) "$FILE")
else
  FIRST_PART=$(head -n $(("$LINES"/2)) "$FILE")
fi

SECOND_PART=$(tail -n $(("$LINES"/2)) "$FILE")

echo "$SECOND_PART" > $FILE
echo "$FIRST_PART" >> $FILE
