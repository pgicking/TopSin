#!/bin/bash

gcc -Wall --coverage -fprofile-arcs -ftest-coverage -lgcov -pg -c -o data_structure.o data_structure.c ;runtest test1.exp; gcov -fb *.c
