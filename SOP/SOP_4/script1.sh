#!/bin/bash

if [[ ! "$#" -eq 1 || ! "$1" =~ ^[0-9]+$ ]] ; then

  echo "usage: $0 number"
  exit 1

fi

FACTORIAL=1

for (( I=1; I<=$1; I++ )) ; do

  FACTORIAL=$((FACTORIAL * I))

done

echo "Factorial of $1 is: $FACTORIAL"

exit 0
