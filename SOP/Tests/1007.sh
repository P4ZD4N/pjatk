#!/bin/bash

mkdir /tmp/s30359

#Checked 4 files with smallest size with this command:
#ls -lS /usr/bin | grep -v "^l" | tail -4

cp /usr/bin/{zegrep,zfgrep,egrep,fgrep} /tmp/s30359

cd /tmp/s30359

I=1
for FILE in $(ls); do
  mv "$FILE" "p$I"
  ((I++))
done
