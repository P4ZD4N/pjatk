#!/bin/bash

read -p "In which directory?: " DIR_NAME

if [[ ! -e $DIR_NAME ]] ; then
  echo "Incorrect directory name: $DIR_NAME"
  exit 1
fi

read -p "Package name: " PCKG_NAME

read -p "Class name: " CLASS_NAME

if [[ -e "$DIR_NAME/$PCKG_NAME/$CLASS_NAME" ]] ; then
  echo "Class $CLASS_NAME already exists"
  exit 1
fi

if [[ ! -d "$DIR_NAME/$PCKG_NAME" ]] ; then
  mkdir "$DIR_NAME/$PCKG_NAME"
fi

touch "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"

echo "package $PCKG_NAME" > "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "public class $CLASS_NAME {" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "	public static void main(String[] args) {" >>"$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "		System.out.println('Hello World!');" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "	}" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
echo "}" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"

exit 0
