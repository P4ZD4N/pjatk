#!/bin/bash

if [ "$#" -eq 0 ]; then
  echo "No arguments!"
  exit 1
fi

while [ "$#" -gt 0 ]; do
  if [[ -f "$1" && ("$1" == *" CPU "* || "$1" == *" CPU."* || "$1" == *" CPU,"*) ]]; then
    echo "$1"
  fi

  shift
done

exit 0
