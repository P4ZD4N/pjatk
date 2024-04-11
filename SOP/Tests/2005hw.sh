#!/bin/bash

X=$(find ~ -type f -name "x*")
Y=$(find ~ -type f -name "y*")
Z=$(find ~ -type f -name "z*")

echo "x*:"
wc -l $X

echo "y*:"
wc -l $Y

echo "z*:"
wc -l $Z
