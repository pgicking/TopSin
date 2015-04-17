#!/bin/bash

make cleanall; make; runtest test.exp; gcov -b *.c
