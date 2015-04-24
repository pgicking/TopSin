#!/bin/bash


lcov -t 'a.out' -o coverage.info -c -d . && genhtml -o result coverage.info && firefox result/index.html
