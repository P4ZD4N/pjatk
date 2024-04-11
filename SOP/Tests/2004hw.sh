#!/bin/bash

mkdir -v {0..9}
LS=$(ls)

mkdir -v "$LS"

rmdir -v {0..9}
rmdir -v "$LS"

