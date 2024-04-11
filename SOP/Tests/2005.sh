#!/bin/bash

JAVA=$(find ~ -type f -name "*.java")
TXT=$(find ~ -type f -name "*.txt")

echo "JAVA:"
wc -l $JAVA

echo "TXT:"
wc -l $TXT
