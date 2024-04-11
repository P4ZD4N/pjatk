#!/bin/bash

clear

read -p "Enter directory: " DIR

if [ ! -d "$DIR" ] ; then
  echo "Error: Directory $DIR not found"
  exit
fi

FILES=$(find "$DIR" -maxdepth 1 -type f)
echo "Files in $DIR directory: $FILES"

FILES_COUNTER=$(echo "$FILES" 2>/dev/null | wc -l)
echo "Number of files in $DIR directory: $FILES_COUNTER"

DIRECTORIES=$(find "$DIR" -mindepth 1 -maxdepth 1 -type d)
DIRECTORY_COUNTER=$(echo "$DIRECTORIES" 2>/dev/null | wc -l)
echo "Number of directories in $DIR directory: $DIRECTORY_COUNTER"

let ALL_ITEMS_COUNTER=$FILES_COUNTER+$DIRECTORY_COUNTER
echo "Number of files and directories in $DIR directory: $ALL_ITEMS_COUNTER"
