#!/bin/bash

#Seconds since 0000-00-00 00:00:00

let YS=$(date +%Y)*12*30*24*60*60
let MoS=$(date +%m-1)*30*24*60*60
let DS=$(date +%D)*24*60*60
let HS=$(date +%H)*60*60
let MiS=$(date +%M)*60
let SS=$(date +%S)

let RES=YS+MoS+DS+HS+MiS+SS

echo $RES
