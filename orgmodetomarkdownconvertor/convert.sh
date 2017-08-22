#!/bin/bash
INFILE="$1"
OUTFILE="$2"

java -jar org-mode-to-markdown-convertor-1.0-SNAPSHOT.jar  --infile="$INFILE" --outfile="$OUTFILE"