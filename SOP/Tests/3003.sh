#!/bin/bash

read FIBO

if [[ $FIBO == ?:? && $FIBO =~ ^[0-9]+:[0-9]+$ ]] ; then
  A=$(echo "$FIBO" | cut -d':' -f1)
  B=$(echo "$FIBO" | cut -d':' -f2)
  NEXT=$(echo "$FIBO" | tr ":" "+" | bc)
else
  echo "Incorrect format. Please enter two numbers in format: N:N"
  exit 1
fi

echo "$B:$NEXT"

exit 0
