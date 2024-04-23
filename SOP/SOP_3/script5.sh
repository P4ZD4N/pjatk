#!/bin/bash

if [ ! "$#" -eq 1 ] ; then

  echo "usage: $0 DIRECTORY"
  exit 1

fi

RES=$(find "$1" -type d | wc -l)
echo "Result: $RES"

exit 0
