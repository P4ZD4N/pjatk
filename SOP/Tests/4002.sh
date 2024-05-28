#!/bin/bash

is_printed_part_of_envelope() {

  X="$1"
  Y="$2"
  N="$3"

  [ "$X" -eq 1 ] && echo 'T' && return 1
  [ "$X" -eq "$N" ] && echo 'T' && return 1
  [ "$Y" -eq 1 ] && echo 'T' && return 1
  [ "$Y" -eq "$N" ] && echo 'T' && return 1
  [ "$X" -eq "$Y" ] && echo 'T' && return 1
  [ "$X" -eq "$((N-Y))" ] && echo 'T' && return 1

  echo 'F'
  return 0
}

draw_envelope() {
 
 for I in $(seq 1 $1); do

    for J in $(seq 1 $1); do

      if [ $(is_printed_part_of_envelope $I $J $1) = 'T' ]; then

        echo -n "X"

      else

        echo -n "."

      fi

    done

    echo

  done
}

read -p "Enter envelope size: " SIZE

draw_envelope $SIZE

exit 0
