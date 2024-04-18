#!/bin/bash

EXECUTABLE="$1"
shift
ARGUMENTS="$@"

[ -z "$EXECUTABLE" ] && exit 1
[ ! -x "$EXECUTABLE" ] && exit 2

"$EXECUTABLE" "$ARGUMENTS"
ERROR_CODE="$?"

case $ERROR_CODE in
0) ;;
1) echo "Invalid source argument" ;;
2) echo "Invalid destination argument" ;;
3) echo "Source argument is not in the current project" ;;
4) echo "Destination argument is not in the current project" ;;
5) echo "Source filename is not a valid java file" ;;
6) echo "No package information in a source file" ;;
7) echo "External tool error: grep" ;;
8) echo "No public class information in a source file" ;;
9) echo "External tool error: grep" ;;
10) echo "Destination already contains sth with this name" ;;
11) echo "Cannot remove source file" ;;
*) echo "Unkown error code" ;;

esac >&2

exit 0
