#!/bin/bash

fibonacci_formatted_text() {

  RESULT=""

  if [ "$1" -ge 0 ]; then

    RESULT="1"

  fi

  if test "$1" -ge 1; then

    RESULT="$Z/1"

  fi

  A=1
  B=1

  for((i=2; i<=$1; i++)); do

    let C=A+B
    let A=B
    let B=C
    RESULT=$RESULT/$C{1..$C}

  done

  echo "$RESULT"
}

read -p "Enter a number: " N
DIRECTORIES=$(fibonacci_formatted_text $N)

eval "echo $DIRECTORIES"
#eval "mkdir $DIRECTORIES"

exit 0
