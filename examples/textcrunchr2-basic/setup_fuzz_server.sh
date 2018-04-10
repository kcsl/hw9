#!/bin/bash

# reset working directory
rm -rf bin
rm -rf bin-instrumented
rm -rf in_dir
rm -rf out_dir

mkdir bin
mkdir in_dir

# unzip the harnessed application
cd bin
jar xf ../harness.jar

# run the kelinci instrumenter
cd ..
java -cp ../../instrumentor/build/libs/kelinci.jar edu.cmu.sv.kelinci.instrumentor.Instrumentor -i bin -o bin-instrumented

# seed the fuzzer inputs
cp test.zip in_dir/

# test the instrumented app with the input example
java -cp bin-instrumented harness.TextCrunchr2 in_dir/test.zip

# start the kelinci server
java -cp bin-instrumented edu.cmu.sv.kelinci.Kelinci harness.TextCrunchr2 @@
