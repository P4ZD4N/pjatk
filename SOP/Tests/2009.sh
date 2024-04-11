#!/bin/bash

read -p "Enter directory, which you would like to remove: " DIR

if [ -d "$DIR" ] ; then
 
 rm -r "$DIR"
  
  if [ $? -eq 0 ] ; then
    echo "OK"
  else
    echo "NOK"
  fi
else
  echo "Directory $DIR does not exist."
fi
