#!/bin/bash

START=$(date +%s)

cleanup() {
  END=$(date +%s)
  let RES=END-START
  echo "You worked $RES seconds"
  exit
}

trap cleanup SIGINT

while true ; do
  echo "Work in progress..."
  sleep 1
done

