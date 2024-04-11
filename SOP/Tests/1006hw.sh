#!/bin/bash

tar -cvf etc-conf-files.tar /etc/*.conf
gzip etc-conf-files.tar
