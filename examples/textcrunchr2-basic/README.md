# TextCrunchr2 (basic harness)
This directory contains a naive test harness for fuzzing the Tweeter web server. It is very slow.

In different terminal windows run the following commands (in order) from the current directory. 

1. `./setup_fuzz_server.sh`

2. `./run_afl.sh`

3. Optionally run: `./watch_fuzzer_inputs.sh`