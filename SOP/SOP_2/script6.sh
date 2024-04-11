#!/bin/bash

clear

echo "(1) Display block devices"
echo "(2) Display files, which names ends with digit or two digits"
echo "(3) Display block devices, which name ends with digit or two digits"
echo "(4) Display files, which names length is equal to 3"
echo "(5) Display files, which names length is less than or equal to 3"

read -p "Enter option: " OPT

BLOCK_DEV=$(ls /dev | grep "^sd")

if [ $OPT -eq 1 ] ; then
  echo $BLOCK_DEV
elif [ $OPT -eq 2 ] ; then
  read -p "Enter directory: " DIR
  echo $(ls $DIR | grep -E "*[0-9]{1,2}$")
elif [ $OPT -eq 3 ] ; then
  echo $(ls $BLOCK_DEV | grep -E "*[0-9]{1,2}$")
elif [ $OPT -eq 4 ] ; then
  read -p "Enter directory: " DIR
  echo $(ls $DIR | grep -E "^.{3}$")
elif [ $OPT -eq 5 ] ; then
  read -p "Enter directory: " DIR
  echo $(ls $DIR | grep -E "^.{3}$")$(ls $DIR | grep -E "^.{2}$")$(ls $DIR | grep -E "^.{1}$")
else
  echo "error"
fi
