#!/bin/bash

read -p "Enter directory: " DIR

if [ $(ls "$DIR" | grep ".sh" | wc -l) -eq 0 ]; then

  echo "No .sh files in $DIR"
  exit 1

fi

for FILE in $(ls "$DIR" | grep ".sh"); do

  LINES=$(wc -l < "$DIR/$FILE")
  HALF_LINES=$(($LINES / 2))

  if [ $((LINES % 2)) -ne 0 ]; then
    HALF_LINES=$((HALF_LINES + 1))
  fi

  MID_LINE=$(sed -n "${HALF_LINES}p" "$FILE")

  echo "Middle line of $FILE: $MID_LINE"

done

exit 0
