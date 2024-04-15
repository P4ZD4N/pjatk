#!/bin/bash

read FIBO

A=$(echo "$FIBO" | cut -d':' -f2)
NEXT=$(echo "$FIBO" | tr ":" "+" | bc)

echo "$A:$NEXT"

exit 0
