#!/bin/bash

APPDIR="$(dirname "$0")"
cd "$APPDIR"
APPDIR="$(pwd)"

java -jar HTML-Index-Generator.jar -i ../../
