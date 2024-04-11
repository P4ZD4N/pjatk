#!/bin/bash

mkdir -vp 1/1/{1..2}/{1..3}/{1..5}/{1..8}/{1..13}/{1..21}

DIR_COUNTER=$(find 1 -type d | wc -l)
echo "Created $DIR_COUNTER directories"
