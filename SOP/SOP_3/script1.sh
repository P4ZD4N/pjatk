#!/bin/bash

if [ "$#" -eq 3 ] ; then
  
  if [[ ! "$1" =~ ^-?[0-9]+$ ]] ; then

    echo "Pierwszy argument musi być liczbą!"
    exit 3

  elif [[ ! "$2" =~ ^-?[0-9]+$ ]] ; then

    echo "Drugi argument musi być liczbą!"
    exit 3

  elif [[ ! "$3" =~ ^-?[0-9]+$ ]] ; then

    echo "Trzeci argument musi być liczbą!"
    exit 3

  fi

  if [ "$1" -eq 0 ] ; then

    echo "A nie może być 0!"
    exit 1

  fi

  A="$1"
  B="$2"
  C="$3"

else

  echo "usage $0: A B C"
  echo "Ax^2 + Bx + C = 0"
  exit 2

fi

DELTA=$(echo "$B^2-4*$A*$C" | bc)
echo "$DELTA"

if [ "$DELTA" -eq 0 ] ; then

  X=$(echo "$B/(2*$A)" | bc)

  echo "Delta = $DELTA"
  echo "X1 = $X, X2 = $X"

elif [ "$DELTA" -gt 0 ] ; then

  X1=$(echo "-($B)+sqrt($DELTA)/2*$A" | bc)
  X2=$(echo "-($B)-sqrt($DELTA)/2*$A" | bc)

  echo "Delta = $DELTA"
  echo "X1 = $X1, X2 = $X2"

else

  echo "Delta < 0, brak rozwiązań!"

fi 

exit 0
