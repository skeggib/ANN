#!/bin/bash

# Recherche de toute les sources
SRC=`find src -name '*.java'`
# Recherche de tout les .jar dans class
JARS=`find jars -name '*.jar'`

# Creation du CLASSPATH
CLASSPATH="$PWD/class"
for jar in $JARS
do
	CLASSPATH="$CLASSPATH:$jar"
done

# Creation du SOURCEPATH
SOURCEPATH="$PWD/src/"

echo "CLASSPATH : $CLASSPATH"
echo "SOURCEPATH : $SOURCEPATH"

# Pour toute les sources
for f in $SRC
do
	# On recupere le chemin + le nom du fichier sans l'extension
	directory=$(dirname $f)
	temp_filename=$(basename $f)
	extension="${filename##*.}"
	filename="${temp_filename%.*}"
	full_filename="$directory/$filename"

	java_file="$full_filename.java"
	class_file="class/${full_filename:3:${#full_filename}-2}.class"

	# Derniere modififcation de la source
	java_file_edit=`stat -c %Y $java_file | sed 's/$java_file//'`

	# Si le .class existe
	if [ -f $class_file ]
	then
		# Derneire modification du .class
		class_file_edit=`stat -c %Y $class_file | sed 's/$class_file//'`

		# Si la source est plus recente que le .class
		if [ $java_file_edit -gt $class_file_edit ]
		then
			# On compile
			echo -e "\033[1;31m$java_file\033[0;0m"
			javac -sourcepath $SOURCEPATH -cp $CLASSPATH -d class $java_file
		fi
	# Si le .class n'existe pas
	else
		# On compile
		echo -e "\033[1;31m$java_file\033[0;0m"
		javac -sourcepath $SOURCEPATH -cp $CLASSPATH -d class $java_file
	fi
done
