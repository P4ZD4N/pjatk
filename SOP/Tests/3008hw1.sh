#!/bin/bash

check_entered_arguments() {

  [ ! -f "$SRC" ] && [ ! -r "$SRC" ] && exit 1
  [ ! -d "$DST" ] && [ ! -w "$DST" ] && exit 2

}

are_absolute_paths_valid() {
  
  [[ ! "$SRC_ABSOLUTE" =~ ^$PROJECT_ROOT ]] && exit 3
  [[ ! "$DST_ABSOLUTE" =~ ^$PROJECT_ROOT ]] && exit 4

}

check_whether_src_ends_with_.java() {

  [[ ! "$SRC" =~ \.java ]] && exit 5

}

check_whether_line_package_is_correct() {

  [ -z "$LINE_PACKAGE" ] && exit 6
  [[ ! "$LINE_PACKAGE" =~ ^[0-9][0-9]*$ ]] && exit 7
  
}

check_whether_line_class_is_correct() {

  [ -z "$LINE_CLASS" ] && exit 8
  [[ ! "$LINE_CLASS" =~ ^[0-9][0-9]*$ ]] && exit 9
  
}

check_whether_file_exists() {

  [ -e "$PROJECT_ROOT/$DST/$SRC_FILENAME" ] && exit 10
  
}

calculate_number_of_lines() {

  NUMBER_OF_LINES=$(cat "$SRC" | wc -l)

}

calculate_number_of_lines_before_package_line() {

  let LINE_PACKAGE_BEFORE=LINE_PACKAGE-1

}

calculate_number_of_lines_after_package_line() {

  let LINE_PACKAGE_AFTER=NUMBER_OF_LINES-LINE_PACKAGE

}

remove_slash_from_dst_pathif_exists_on_the_end() {
  
  if [[ "$DST" =~ /$ ]] ; then
    LINE_LENGTH=$(echo -n "$DST" | wc -c)
    let LINE_LENGTH--
    DST=$(echo -n "$DST" | cut -c1-"$LINE_LENGTH")
  fi
  
}

fill_file_in_new_location() {

  head -n "$LINE_PACKAGE_BEFORE" "$SRC" > "$DST/$SRC_FILENAME"
  echo "package $(echo $DST | tr '/' '.');" >> "$DST/$SRC_FILENAME"
  tail -n "$LINE_PACKAGE_AFTER" "$SRC" >> "$DST/$SRC_FILENAME"

}

remove_file_in_old_location() {

  rm "$SRC" || exit 11

}

SRC="$1"
DST="$2"
PROJECT_ROOT=$(pwd)
SRC_ABSOLUTE=$(readlink -f "$1")
DST_ABSOLUTE=$(readlink -f "$2")
LINE_PACKAGE=$(cat "$SRC" | egrep -n " *package.+;" | head -n 1 | cut -d":" -f1 )
LINE_CLASS=$(cat "$SRC" | egrep -n " *public +class" | head -n 1 | cut -d":" -f1)
SRC_FILENAME=$(basename "$SRC")

check_entered_arguments

are_absolute_paths_valid

check_whether_src_ends_with_.java

check_whether_line_package_is_correct

check_whether_line_class_is_correct

check_whether_file_exists

calculate_number_of_lines

calculate_number_of_lines_before_package_line

calculate_number_of_lines_after_package_line

remove_slash_from_dst_pathif_exists_on_the_end

fill_file_in_new_location

remove_file_in_old_location

exit 0
