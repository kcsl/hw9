#!/bin/bash

# reset working directory
rm -rf bin
rm -rf bin-instrumented
rm -rf in_dir
rm -rf out_dir
rm -rf cookies

mkdir bin
mkdir in_dir

# unzip the harnessed application
cd bin
jar xf ../harness.jar

# run the kelinci instrumenter
cd ..
java -cp ../../instrumentor/build/libs/kelinci.jar edu.cmu.sv.kelinci.instrumentor.Instrumentor -i bin -o bin-instrumented

# seed the fuzzer inputs
echo "test" > in_dir/example

# test the instrumented app with the input example
java -cp bin-instrumented harness.Blogger in_dir/example

# start the kelinci server
java -cp bin-instrumented edu.cmu.sv.kelinci.Kelinci harness.Blogger @@