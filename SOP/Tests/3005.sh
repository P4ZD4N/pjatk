#!/bin/bash

CONF_FILE="gen.conf"

read -p "Package name: " PCKG_NAME

read -p "Class name: " CLASS_NAME

if [[ -e "$PCKG_NAME/$CLASS_NAME" ]] ; then
  echo "Class $CLASS_NAME already exists"
  exit 1
fi

if [[ ! -d "$PCKG_NAME" ]] ; then
  mkdir "$PCKG_NAME"
fi

touch "$PCKG_NAME/$CLASS_NAME.java"

[ ! -f "$CONF_FILE" ] || 
[ ! -r "$CONF_FILE" ] && 
{ echo "Config file is not available" >&2 ; exit 2; }

GEN_MAIN=$(grep "MAIN=TRUE" "$CONF_FILE" > /dev/null && echo 'T' || echo 'F')
GEN_HELLO=$(grep "HELLO_WORLD=TRUE" "$CONF_FILE" > /dev/null && echo 'T' || echo 'F')

[ "$GEN_MAIN" = 'T' ] && echo "Generator will create main function"
[ "$GEN_MAIN" = 'T' -a "$GEN_HELLO" = 'T' ] && echo "Generator will create hello world code"

(
echo "package $PCKG_NAME;"
echo
echo "public class $CLASS_NAME {"
if [ "$GEN_MAIN" = 'T' ] ; then
  echo "	public static void main(String[] args) {"
  if [ "$GEN_HELLO" = 'T' ] ; then
    echo
    echo "		System.out.println(\"Hello World!\");"
    echo 
  fi
  echo "	}"
fi
echo "}"
) > "$PCKG_NAME/$CLASS_NAME.java"

exit 0
