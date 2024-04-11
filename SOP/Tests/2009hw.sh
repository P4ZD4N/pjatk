#!/bin/bash

read -p "Enter file, which you would like to remove: " FILE

if [ -f "$FILE" ] ; then
 
 rm "$FILE"
  
  if [ $? -eq 0 ] ; then
    banner "OK"
  else
    banner "NOK"
  fi
else
  echo "File $FILE does not exist."
fi
