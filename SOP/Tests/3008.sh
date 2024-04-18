#!/bin/bash

SRC="$1"
DST="$2"
PROJECT_ROOT=$(pwd)

[ ! -f "$SRC" ] && [ ! -r "$SRC" ] && exit 1
[ ! -d "$DST" ] && [ ! -w "$DST" ] && exit 2

SRC_ABSOLUTE=$(readlink -f "$SRC")
DST_ABSOLUTE=$(readlink -f "$DST")

[[ ! "$SRC_ABSOLUTE" =~ ^$PROJECT_ROOT ]] && exit 3
[[ ! "$DST_ABSOLUTE" =~ ^$PROJECT_ROOT ]] && exit 4

[[ ! "$SRC" =~ \.java ]] && exit 5

LINE_PACKAGE=$(cat "$SRC" | egrep -n " *package.+;" | head -n 1 | cut -d":" -f1 )

[ -z "$LINE_PACKAGE" ] && exit 6
[[ ! "$LINE_PACKAGE" =~ ^[0-9][0-9]*$ ]] && exit 7

LINE_CLASS=$(cat "$SRC" | egrep -n " *public +class" | head -n 1 | cut -d":" -f1)

[ -z "$LINE_CLASS" ] && exit 8
[[ ! "$LINE_CLASS" =~ ^[0-9][0-9]*$ ]] && exit 9

SRC_FILENAME=$(basename "$SRC")
[ -e "$PROJECT_ROOT/$DST/$SRC_FILENAME" ] && exit 10

NUMBER_OF_LINES=$(cat "$SRC" | wc -l)

let LINE_PACKAGE_BEFORE=LINE_PACKAGE-1
let LINE_PACKAGE_AFTER=NUMBER_OF_LINES-LINE_PACKAGE

if [[ "$DST" =~ /$ ]] ; then
  LINE_LENGTH=$(echo -n "$DST" | wc -c)
  let LINE_LENGTH--
  DST=$(echo -n "$DST" | cut -c1-"$LINE_LENGTH")
fi

head -n "$LINE_PACKAGE_BEFORE" "$SRC" > "$DST/$SRC_FILENAME"
echo "package $(echo $DST | tr '/' '.');" >> "$DST/$SRC_FILENAME"
tail -n "$LINE_PACKAGE_AFTER" "$SRC" >> "$DST/$SRC_FILENAME"

rm "$SRC" || exit 11

exit 0
