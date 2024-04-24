#!/bin/bash

if [ ! "$#" -eq 1 ] ; then

  echo "usage: $0 DIRECTORY"
  exit 1

fi

if [ ! -d "$1" ] ; then

  echo "Entered directory doesn't exist"
  exit 2

fi

RES=$(ls -d "$1"/[bec]*/)

echo "$RES"

exit 0
