#!/usr/bin/env bash
source functions.sh

rm -f ./cookies

createUser a a a

login a a

tweetNoLogin "$1"
