#!/bin/bash

touch {0..9}
LS=$(ls)
NAME=$LS
touch "$NAME"

rm -v {0..9}
rm -v "$NAME"
