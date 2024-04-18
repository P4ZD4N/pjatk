#!/bin/bash
#SCRIPT validator.sh

[ ! "$#" -eq 1 ] && { echo "usage: $0 PACKAGE_NAME" >&2 ; exit 1 ; }

PACKAGE="$1"
PACKAGE_DIR=$(echo "$PACKAGE" | tr '.' '/')
EXECUTOR="$(pwd)/3007java_validator.sh"
OLD_DIR=$(pwd)

cd "$PACKAGE_DIR"
find . -name "*.java" -exec "$EXECUTOR" {} "$PACKAGE" \;
cd "$OLD_DIR"
