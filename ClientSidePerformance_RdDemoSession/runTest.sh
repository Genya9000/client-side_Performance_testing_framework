#!/bin/sh
ITER=0

while [ "$ITER" -le "5" ]
do
  echo "Looping ... number $ITER"
  mvn clean test -Dbrowser=ChromeLocal -Dtest=RDDemo
  ITER=$((ITER + 1 ))
done
