#!/bin/bash

if [ ! "$#" -eq 2 ] ; then

  echo "usage: $0 DIRECTORY FILE_EXTENSIONS"
  exit 1

fi

DIR="$1"
EXT="$2"

RES=$(find "$DIR" -type f -name "*.$EXT")

echo "$RES"

exit 0
