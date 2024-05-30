#!/bin/bash

if [ "$#" -ne 2 ]; then
  echo "usage: $0 number1 number2"
  exit 1
fi

if [[ ! "$1" =~ ^[0-9]+$ || ! "$2" =~ ^[0-9]+$ ]]; then
  echo "Both arguments must be numbers!"
  exit 2
fi

for i in $(seq $1 $2)
do
  factorial=1
  for j in $(seq 1 $i)
  do
    factorial=$((factorial * $j))
  done
  echo "Factorial of $i: $factorial"
done

exit 0
