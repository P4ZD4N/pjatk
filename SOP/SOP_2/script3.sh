#!/bin/bash

clear

echo "QUADRATIC EQUATION CALCULATOR"

read -p "Enter A: " A

if [ $A -eq 0 ] ; then
  echo "A cannot be equal to 0"
  exit 1
fi

read -p "Enter B: " B
read -p "Enter C: " C

echo "$A""a + $B""b + $C""c = 0"

DISCRIMINANT=$(($B ** 2 - 4 * $A * $C))

echo $DISCRIMINANT

if [ $DISCRIMINANT -lt 0 ] ; then
  echo "No solutions"
elif [ $DISCRIMINANT -eq 0 ] ; then
  X=$((-($B / (2 * $A))))
  echo "x1 = $X, x2 = $X"
else
  SQUARE_ROOT=$(echo "scale=0; sqrt($DISCRIMINANT)" | bc)
  X1=$(( (-$B+$SQUARE_ROOT) / (2*$A) ))
  X2=$(( (-$B-$SQUARE_ROOT) / (2*$A) ))
  echo "x1 = $X1, x2 = $X2"
fi
