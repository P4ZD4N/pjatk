#!/bin/bash

read -p "Enter directory (directories): " DIR

bash -xc "$(find $DIR -type f -executable)"
