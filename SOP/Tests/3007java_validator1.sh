#!/bin/bash

input_validator() {

  [ -z "$1" ] && exit 1
  [ -z "$2" ] && exit 1
  [[ ! "$2" =~ ^[a-zA-Z]+$ ]] && { echo "Invalid package name $2" >&2 ; exit 1 ; } 

  echo "$1" | grep "\.java$" > /dev/null || { echo "File $1 has not java extension!" >&2 ; exit 1 ; }
  
}

basic_validator() {

  WORDS_IN_NAME=$(echo "JAVA_SOURCE_FILE" | rev | cut -d'.' -f2-100 | rev | tr ' ' '\n' | wc -l)

  if [ "$WORDS_IN_NAME" -ne 1 ] ; then
    echo "File name $1 has spaces!" >&2 ; exit 2 ;
  fi
  
}

package_validator() {

  cd "$2"
  FIRST_LINE=$(cat "$1" | head -n 1)
  PACKAGE_PATTERN=" *package *$2 *;"

  if [[ ! "$FIRST_LINE" =~ $PACKAGE_PATTERN ]] ; then
    echo "File $1 does not contain valid package name!" >&2
    let ERRNO++
  fi
  
}

java_class_validator() {

  JAVA_CLASS_NAME=$(echo "$1" | cut -d'/' -f2 | cut -d'.' -f1)
  PUBLIC_CLASS=$(cat "$1" | egrep " *public +class +$JAVA_CLASS_NAME[ {/]" | wc -l)
 
  if [ "$PUBLIC_CLASS" -ne 1 ] ; then
    echo "File $1 does not contain valid class name!" >&2
    let ERRNO++
  fi
  
} 

[ ! "$#" -eq 2 ] && { echo "usage: $0 JAVA_SOURCE_FILE PACKAGE_NAME" >&2 ; exit 1 ; }

JAVA_SOURCE_FILE="$1"
PACKAGE_NAME="$2"
ERRNO=0

input_validator "$JAVA_SOURCE_FILE" "$PACKAGE_NAME"
basic_validator "$JAVA_SOURCE_FILE" "$PACKAGE_NAME"
package_validator "$JAVA_SOURCE_FILE" "$PACKAGE_NAME"
java_class_validator "$JAVA_SOURCE_FILE" "$PACKAGE_NAME"

if [ "$ERRNO" -ne 0 ] ; then
  echo "File $JAVA_CLASS_NAME.java has $ERRNO errors!"
else
  echo "File $JAVA_CLASS_NAME.java is valid!"
fi

exit 0
