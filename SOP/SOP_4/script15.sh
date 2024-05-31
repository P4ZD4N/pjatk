#!/bin/bash

if [ "$#" -ne 1 ]; then
  echo "usage: $0 file"
  exit 1
fi

numbers=0
letters=0

while read -r line; do
  for something in $line; do
    if [[ $something =~ ^[0-9]+$ ]]; then
      for char in $(echo $something | grep -o .); do
        ((numbers++))
      done
    else
      for char in $(echo $something | grep -o .); do
        ((letters++))
      done
    fi
  done
done < "$1"

echo "File $1 contains $numbers numbers and $letters letters"

exit 0
