#!/bin/bash

clear

echo "Choose option:"
echo "(1) Display files, which contains 'a' character"
echo "(2) Display files, which are readable for all"
echo "(3) Display files, which ends with 's' or 'd'"
echo "(4) Display files, which ends with lowercase letter"

read -p "Option: " OPT
read -p "Directory: " DIR

if [ $OPT -eq 1 ] ; then
  echo $(find $DIR -type f -name "*a*")
elif [ $OPT -eq 2 ] ; then
  echo $(find $DIR -type f -perm /a+r)
elif [ $OPT -eq 3 ] ; then
  echo $(find $DIR -type f -name "*[sd]")
elif [ $OPT -eq 4 ] ; then
  echo $(find $DIR -type f -name "*[a-z]")
else
  echo "error"
fi
