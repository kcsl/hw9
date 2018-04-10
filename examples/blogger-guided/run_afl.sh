#!/bin/bash

afl-fuzz -t 20000 -i in_dir -o out_dir ../../fuzzerside/interface @@