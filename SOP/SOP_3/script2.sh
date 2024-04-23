#!/bin/bash

if [ ! "$#" = 1 ] ; then

  echo "usage: $0 FILE"
  exit 1

fi

if [ ! -w "$1" ] ; then

  chmod +w "$1"
  echo "Added write right to $1"

else

  chmod -w "$1"
  echo "Removed write right from $1"

fi

exit 0
