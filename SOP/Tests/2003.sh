#!/bin/bash

let Y=$(date +%Y-1970)
let M=$(date +%m-1)
let D=$(date +%d-1)

let YS=Y*12*30*24*60*60
let MS=M*30*24*60*60
let DS=D*24*60*60

let RES=YS+MS+DS

echo $RES
