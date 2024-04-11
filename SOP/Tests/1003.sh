#!/bin/bash

mkdir -v {1..40}
echo "Created 40 directories"

rmdir -v {1..40}
echo "Removed created directories"
