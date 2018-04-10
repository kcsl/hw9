#!/bin/bash

afl-fuzz -t 100000 -i in_dir -o out_dir ../../fuzzerside/interface @@