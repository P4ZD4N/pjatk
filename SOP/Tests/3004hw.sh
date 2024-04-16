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

read -p "Do you want to add comment to this class? (y/n): " CHOICE

if [[ $CHOICE == "y" || $CHOICE == "Y" ]] ; then
  read -p "Who generated this class?: " AUTHOR
  
  if [[ -z "$AUTHOR" ]] ; then
    echo "Author is empty"
    exit 1
  fi
  
  DATE=$(date +'%Y-%m-%d')
  
  read -p "What is purpose of this class?: " PURPOSE
  
  if [[ -z "$PURPOSE" ]] ; then
    echo "" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
    echo "// Author: $AUTHOR" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
    echo "// Date created: $DATE" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
  else 
    echo "" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
    echo "// Author: $AUTHOR" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
    echo "// Date created: $DATE" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
    echo "// Purpose: $PURPOSE" >> "$DIR_NAME/$PCKG_NAME/$CLASS_NAME.java"
  fi
  
elif [[ $CHOICE == "n" || $CHOICE == "N" ]] ; then
  echo "..."
  exit 0
else 
  echo "Incorrect choice"
fi

exit 0
