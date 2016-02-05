#!/bin/bash


src_folder="src"
class_folder="class"
jars_folder="jars"
progress_bar_length=30


# ------------------------------------------------------------ #

if [ ! -d "class" ]
then
	mkdir class
fi

# Recherche de toute les sources
SRC=`find $src_folder -name '*.java' | sort`
SRC_count=`find $src_folder -name '*.java' | wc -l`
# Recherche de tout les .jar
JARS=`find $jars_folder -name '*.jar'`

# Creation du CLASSPATH
CLASSPATH="$PWD/$class_folder"
for jar in $JARS
do
	CLASSPATH="$CLASSPATH:$jar"
done

# Creation du SOURCEPATH
SOURCEPATH="$PWD/$src_folder"

i=0
# Pour toute les sources
for f in $SRC
do



	# --- File Names and Modifications --- #

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


	# --- Compilation --- #

	# Si le .class existe
	if [ -f $class_file ]
	then
		# Derneire modification du .class
		class_file_edit=`stat -c %Y $class_file | sed 's/$class_file//'`

		# Si la source est plus recente que le .class
		if [ $java_file_edit -gt $class_file_edit ]
		then
			# On compile
			javac -sourcepath $SOURCEPATH -cp $CLASSPATH -d $class_folder $java_file
			printf "\r\033[2K"
			printf "\033[1;32m"
			printf "$java_file\n"
		else
			printf "\r\033[2K"
			printf "\033[1;34m"
			printf "$java_file\n"
		fi
	# Si le .class n'existe pas
	else
		# On compile
		javac -sourcepath $SOURCEPATH -cp $CLASSPATH -d $class_folder $java_file
		printf "\r\033[2K"
		printf "\033[1;32m"
		printf "$java_file\n"
	fi


	# --- Progress --- #
 
	printf "\r\033[2K"

	i=$((i + 1))
	progress=$(echo "$i / $SRC_count * $progress_bar_length" | bc -l)
	progress=`echo "$progress" | awk '{printf("%d\n",$1 + 0.5)}'`

	printf "\033[1;32m"
	printf "["
	j=0
	while [ $j -lt $progress_bar_length ]
	do
		if [ $j -lt $progress ]
		then
			printf "#"
		else
			printf "-"
		fi
		j=$((j + 1))
	done
	printf "]"
	printf "\033[0;0m"
	printf " - "
	printf "\033[1;37m"
	printf "$i / $SRC_count"
	printf "\033[0;0m"
	printf " - "
	printf "\033[0;34m"
	printf "$java_file"
	printf "\033[0;0m"

done

printf "\n"
printf "\033[0;0m"
