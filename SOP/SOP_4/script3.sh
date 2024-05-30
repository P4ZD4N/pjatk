#!/bin/bash

read -p "Enter number of argument: " N

if [[ $# < "$N" || "$N" -lt 1 ]]; then

  echo "Invalid number"
  exit 1

fi

echo "$N argument: ${!N}"

exit 0
