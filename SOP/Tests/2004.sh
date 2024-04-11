#!/bin/bash

touch {0..9}
LS=$(ls)
touch "$LS"

rm -v {0..9}
rm -v "$LS"
