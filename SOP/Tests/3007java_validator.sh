#!/bin/bash

#SCRIPT java_validator.sh

JAVA_SOURCE_FILE="$1"
PACKAGE_NAME="$2"
ERRNO=0

[ -z "$JAVA_SOURCE_FILE" ] && exit 1
[ -z "$PACKAGE_NAME" ] && exit 1
[[ ! "$PACKAGE_NAME" =~ ^[a-zA-Z]+$ ]] && { echo "Invalid package name $PACKAGE_NAME" >&2 ; exit 1 ; } 

echo "$JAVA_SOURCE_FILE" | grep "\.java$" > /dev/null || { echo "File $JAVA_SOURCE_FILE has not java extension!" >&2 ; exit 1 ; }

WORDS_IN_NAME=$(echo "JAVA_SOURCE_FILE" | rev | cut -d'.' -f2-100 | rev | tr ' ' '\n' | wc -l)

if [ "$WORDS_IN_NAME" -ne 1 ] ; then
  echo "File name $JAVA_SOURCE_FILE has spaces!" >&2 ; exit 2 ;
fi

FIRST_LINE=$(cat "$JAVA_SOURCE_FILE" | head -n 1)
PACKAGE_PATTERN=" *package *$PACKAGE_NAME *;"

if [[ ! "$FIRST_LINE" =~ $PACKAGE_PATTERN ]] ; then
  echo "File $JAVA_SOURCE_FILE does not contain valid package name!" >&2
  let ERRNO++
fi

JAVA_CLASS_NAME=$(echo "$JAVA_SOURCE_FILE" | cut -d'/' -f2 | cut -d'.' -f1)
PUBLIC_CLASS=$(cat "$JAVA_SOURCE_FILE" | egrep " *public +class +$JAVA_CLASS_NAME[ {/]" | wc -l)

if [ "$PUBLIC_CLASS" -ne 1 ] ; then
  echo "File $JAVA_SOURCE_FILE does not contain valid class name!" >&2
  let ERRNO++
fi

if [ "$ERRNO" -ne 0 ] ; then
  echo "File $JAVA_CLASS_NAME.java has $ERRNO errors!"
else
  echo "File $JAVA_CLASS_NAME.java is valid!"
fi

exit 0
