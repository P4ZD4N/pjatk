#!/bin/bash

silent_echo() {
  if [ "$1" = 'F' ] ; then
    shift
    echo "$@"
  fi
}

log() {
  if [ "$1" = 'T' ] ; then
    if [ -f "log" ] ; then
      shift
      echo "$@"
      echo "$@" >> log
    else
      touch "log"
      shift
      echo "$@"
      echo "$@" >> log
    fi
  fi
}
 
[ "$#" -lt 2 ] && { echo "usage: $0 PACKAGE_NAME CLASS_NAME [-s|--silent, -l|--log] " >&2; exit 1; }

CONF_FILE="gen.conf"
PCKG_NAME="$1"
CLASS_NAME="$2"
SILENT_MODE=$( [ $# -ge 3 ] && [ "$3" = "-s" -o "$3" = "--silent" ] && echo 'T' || echo 'F')
LOG_MODE=$( [ $# -ge 3 ] && [ "$3" = "-l" -o "$3" = "--log" ] && echo 'T' || echo 'F')

if [[ -e "$PCKG_NAME/$CLASS_NAME" ]] ; then
  silent_echo "$SILENT_MODE";
  log "$LOG_MODE" "Class $CLASS_NAME already exists"
  exit 1
fi

if [[ ! -d "$PCKG_NAME" ]] ; then
  mkdir "$PCKG_NAME"
fi

touch "$PCKG_NAME/$CLASS_NAME.java"

[ ! -f "$CONF_FILE" ] || 
[ ! -r "$CONF_FILE" ] && 
{ 
  silent_echo "$SILENT_MODE";
  log "$LOG_MODE" "Config file is not available"
  exit 2;
}

GEN_MAIN=$(grep "MAIN=TRUE" "$CONF_FILE" > /dev/null && echo 'T' || echo 'F')
GEN_HELLO=$(grep "HELLO_WORLD=TRUE" "$CONF_FILE" > /dev/null && echo 'T' || echo 'F')

[ "$GEN_MAIN" = 'T' ] && {
  silent_echo "$SILENT_MODE";
  log "$LOG_MODE" "Generator will create main function"
}
[ "$GEN_MAIN" = 'T' -a "$GEN_HELLO" = 'T' ] && {
  silent_echo "$SILENT_MODE";
  log "$LOG_MODE" "Generator will create hello world code"
}

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
