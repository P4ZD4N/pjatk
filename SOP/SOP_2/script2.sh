#!/bin/bash

read -p "Enter number: " A
echo "You entered value: $A"

#Arithmetic operations

B=$((A+1))
B=$[A+1]
let B=A+1
B=`expr $A + 1`
B=$(expr $A + 1)

#If statement

echo "A: $A"
echo "B: $B"

if [ $A -gt $B ] ; then
  echo "A > B"
elif [ ! $A -ne $B ] ; then
  echo "A = B"
else
  echo "A < B"
fi
