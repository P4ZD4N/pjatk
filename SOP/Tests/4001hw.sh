#!/bin/bash

INPUT=$(./4001.sh)

COUNTER=$(echo "$INPUT" | tr ' ' '\n' | wc -l)

echo "$INPUT"
echo "Created $COUNTER directories"

exit 0
