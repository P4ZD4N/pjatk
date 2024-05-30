#!/bin/bash

if [[ "$#" -lt 1 || "$#" -gt 2 ]]; then
  echo "usage: $0 file [-s|-p]"
  exit 1
fi

if [ ! -f "$1" ]; then
  echo "File '$1' does not exist!"
  exit 2
fi

if [ "$2" == "-s" ]; then

  sum=0
  while read line; do
    for number in $line; do
      if [[ $number =~ ^[0-9]+$ ]]; then
        sum=$((sum + number))
      fi
    done
  done < "$1"
  echo "Sum: $sum"

elif [ "$2" == "-p" ]; then

  product=1
  while read line; do
    for number in $line; do
      if [[ $number =~ ^[0-9]+$ ]]; then
        product=$((product * number))
      fi
    done
  done < "$1"
  echo "Product: $product"

else

  echo "Invalid option '$2'!"
  exit 3

fi

exit 0
