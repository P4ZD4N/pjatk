#!/bin/bash

read -p "Enter number: " A

if [ $A -eq 0 ] ; then
  echo "$A = 0"
elif [ $A -gt 0 ] ; then
  echo "$A > 0"
elif [ $A -lt 0 ] ; then
  echo "$A < 0"
else
  echo "error" 
fi
