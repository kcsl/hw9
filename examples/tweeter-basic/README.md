# Tweeter AC Time (basic harness)
This directory contains a naive test harness for fuzzing the Tweeter web server. It is very slow.

In different terminal windows run the following commands (in order) from the current directory. Note that the Tweeter server can take several minutes to start up. When the Tweeter application has finished startup it will the last log message will read `initialization completed in XXX ms`. Do not start the fuzz server until the Tweeter application has completed startup.

1. `./startServer.sh`

2. `./setup_fuzz_server.sh`

3. `./run_afl.sh`

4. Optionally run: `./watch_fuzzer_inputs.sh`