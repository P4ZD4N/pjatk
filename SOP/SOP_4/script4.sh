#!/bin/bash

read -p "Enter directory: " DIR

if [ $(ls $DIR | grep ".java" | wc -l) -eq 0 ]; then

  echo "No files with .java extension!"
  exit 1

fi

for FILE in $(ls $DIR | grep ".java"); do

  LINES=$(cat $DIR/$FILE | wc -l)
  echo "$FILE: $LINES lines"

done

exit 0
