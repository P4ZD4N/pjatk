#!/bin/bash

if [ ! "$#" = 1 ] ; then

  echo "usage: $0 DIRECTORY"
  exit 1

fi

if [ ! -d "$1" ] ; then

  echo "Entered directory does not exist"
  exit 2

fi

DIR="$1"

RES=$(find "$DIR" -maxdepth 1 -type f -name "*b*" -a -name ".*")

if [ -z "$RES" ] ; then

  echo "Script can't find files which matches to the pattern"
  exit 3

fi

echo "$RES"
echo "$RES" > file

exit 0
