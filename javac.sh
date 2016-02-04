#!/bin/bash

JARS=`find class -name '*.jar'`
# Creation du CLASSPATH
CLASSPATH="$PWD/class"
for jar in $JARS
do
	CLASSPATH="$CLASSPATH:$jar"
done

javac -d class -cp $CLASSPATH $1