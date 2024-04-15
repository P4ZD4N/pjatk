#!/bin/bash

read ARIT

A=$(echo "$ARIT" | cut -d':' -f1)
B=$(echo "$ARIT" | cut -d':' -f2)

DIFF=$((B-A))
NEXT=$((B+DIFF))

echo "$B:$NEXT"

exit 0
