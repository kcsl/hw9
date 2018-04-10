# Blogger AC Time (guided fuzzing harness)
This directory contains a guided fuzzer for fuzzing the Blogger web server URIVerifier logic.

In different terminal windows run the following commands (in order) from the current directory.

2. `./setup_fuzz_server.sh`

3. `./run_afl.sh`

4. Optionally run: `./watch_fuzzer_inputs.sh`