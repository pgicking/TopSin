#!/bin/bash

lcov -t 'clic' -o coverage.info -c -d . && genhtml -o result coverage.info && firefox result/index.html
