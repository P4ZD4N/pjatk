#!/bin/bash

if [ "$#" -ne 2 ]; then
  echo "usage: $0 rows columns"
  exit 1
fi

if [[ ! "$1" =~ ^[0-9]+$ || ! "$2" =~ ^[0-9]+$ ]]; then
  echo "Both arguments must be numbers!"
  exit 2
fi

for (( i=1; i<="$1"; i++ )); do
  for (( j=1; j<="$2"; j++ )); do
    printf "%-5d" $((i * j))
  done
  echo
done

exit 0
