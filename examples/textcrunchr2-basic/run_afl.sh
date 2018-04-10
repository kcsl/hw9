#!/bin/bash

afl-fuzz -t 300000 -i in_dir -o out_dir ../../fuzzerside/interface @@