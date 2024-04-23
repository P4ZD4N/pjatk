#!/bin/bash

if [ ! "$#" -eq 1 ] ; then

  echo "usage: $0 DIRECTORY"
  exit 1

fi

./script3.sh "$1"

if [ "$?" -eq 0 ] ; then

  FILES_COUNTER=$(./script3.sh "$1" | wc -l)
  echo "Found files: $FILES_COUNTER"

else

  echo "Something went wrong"
  exit 2

fi

exit 0
